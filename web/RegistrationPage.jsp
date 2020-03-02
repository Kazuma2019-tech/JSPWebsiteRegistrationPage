<%-- 
    Document   : RegistrationPage
    Created on : 27-Feb-2020, 16:41:16
    Author     : oladele K00245120
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ page import="java.sql.*" %>
        <%@ page import="java.io.*" %>
        <title>Registration Page</title>
    </head>
    <body>
        <h2>Data from the table customer_registration</h2>
        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con
                        = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprisedevelopment?autoReconnect=TRUE&useSSL=FALSE", "root", "");
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM registrationpagetable");
                ResultSet rs = ps.executeQuery();
                
        %>
        <table cellpadding="15" border="1" style="background-color: #ffffcc;">
            <%  while (rs.next()) {
            %>

            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
            </tr>

            <% }%>
            <% //close all the connections.
                rs.close();

            } catch (Exception ex) {
            %>
            </font>
            <font size="+3" color="red"></br>


            <%
                    out.println("Unable to connect to database.");
                }
            %>

        </table>
    </body>
</html>
