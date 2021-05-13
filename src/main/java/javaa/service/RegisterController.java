package javaa.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        response.setContentType("text/html");

        String f_name = request.getParameter("firstname");
        String l_name = request.getParameter("lastname");
        String u_id =request.getParameter("uid");
        String e_id = request.getParameter("emailid");
        String p_word = request.getParameter("password");
        String confirm_pass=request.getParameter("confirm");
        String cont= request.getParameter("contact");
        String date = request.getParameter("dob");
        try
        {
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","admin123");

            if(p_word.equals(confirm_pass))
            {
                String str="Insert into industry values";
                PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1, f_name);
                ps.setString(2, l_name);
                ps.setString(3,u_id);
                ps.setString(4, e_id);
                ps.setString(5, p_word);
                ps.setString(6, cont);
                ps.setString(7, date);
                ps.executeUpdate();

                RequestDispatcher rd = request.getRequestDispatcher("successful.jsp");
                rd.forward(request, response);

            }

            else
            {

                RequestDispatcher rd = request.getRequestDispatcher("unsuccessful.jsp");
                rd.forward(request, response);
            }


        }
        catch(Exception exception)
        {
            System.out.println(exception);

        }



    }

}