package controller;

import dao.sql.CrewDAOSQL;
import dao.sql.MemberDAOSQL;
import entity.Crew;
import entity.Member;
import service.UserService;
import utils.DBConnection;
import utils.Hasher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controller.MainPageController")
public class MainPageController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String)req.getSession().getAttribute("email");
        String phash = (String)req.getSession().getAttribute("phash");

        if (email != null && phash != null) {
            Member member = UserService.auth(email, phash);
            if (member == null) {
                req.getSession().invalidate();
            }
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "logout": {
                req.getSession().invalidate();
                break;
            }
            case "addcrew": {
                ArrayList<Member> members = new ArrayList<>();
                String[] membersS = {"pilot0", "pilot1", "navigator", "radioman", "stewardess0", "stewardess1", "stewardess2"};
                for (String mS : membersS) {
                    try {
                        members.add(new MemberDAOSQL().getMemberByID(Integer.parseInt(req.getParameter(mS))));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    new CrewDAOSQL().addCrew(new Crew(-1, members));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            default: {
                break;
            }
        }
        resp.sendRedirect("/");
    }
}
