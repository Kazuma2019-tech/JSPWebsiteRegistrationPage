/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;



/**
 * Servlet implementation class UserDataServlet
 */
public class RegistrationController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("Name");
        String pass = request.getParameter("password");
        String age = request.getParameter("age");
        String Email = request.getParameter("Email");
        String Phone = request.getParameter("Phone_number");

        // validate given input
        if (name.isEmpty() || age.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            out.println("<font color=red>Please fill all the fields</font>");
            rd.include(request, response);
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                // loads mysql driver
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisedevelopment?autoReconnect=TRUE&useSSL=FALSE", "root", "");
            
                PreparedStatement ps = con.prepareStatement("INSERT INTO registrationpagetable(user_name, password, age, email, Phone_no)VALUES(?,?,?,?,?)"); // generates sql query

                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, age);
                ps.setString(4, Email);
                ps.setString(5, Phone);

                ps.executeUpdate(); // execute it on test database
                
                ps.close();
                con.close();
            } 
            catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            RequestDispatcher rd = request.getRequestDispatcher("RegistrationPage.jsp");
            rd.forward(request, response);
        }
    }
}
