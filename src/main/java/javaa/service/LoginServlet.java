package javaa.service;

import javaa.controller.DB;
import javaa.controller.ServletMain;
import javaa.controller.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("login.html");
        dispatcher.forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String Name = req.getParameter("Name");
        String password = req.getParameter("password");
        User userAccount = DB.findUser(Name, password);

        if (userAccount == null) {
            String errorMessage = "Invalid Name or Password";

            req.setAttribute("errorMessage", errorMessage);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("login.html");
            dispatcher.forward(req, resp);
        }
        ServletMain.LogUserstore(req.getSession(), userAccount);




    }

}
