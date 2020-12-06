package controller;

import dao.sql.MemberDAOSQL;
import entity.Member;
import service.UserService;
import utils.Hasher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.SignUpController")
public class SignUpController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("GET");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phash = password.isEmpty() ? "" : Hasher.SHA256(password);

        Member member = UserService.register(firstName, middleName, lastName, email, phash);
        if (member != null) {
            req.getSession().setAttribute("member", member);
        }

        resp.sendRedirect("/");
    }
}
