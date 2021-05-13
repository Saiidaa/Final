package javaa.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public static boolean validate(String user_id, String pass_word)
    {
        boolean status =false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","Saida","admin123");

            String loq="select Username and Password";

            PreparedStatement ps=con.prepareStatement(loq);
            ps.setString(1, user_id);
            ps.setString(2, pass_word);

            ResultSet rs = ps.executeQuery();
            status=rs.next();

        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }


        return status;


    }


}
