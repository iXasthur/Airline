package controller;

import dao.sql.MemberDAOSQL;
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
        System.out.println("POST");
    }
}
