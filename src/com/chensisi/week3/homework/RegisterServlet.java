package com.chensisi.week3.homework;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/register")
//        initParams={
//                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseName=userdb"),
//                @WebInitParam(name="username",value="sa"),
//                @WebInitParam(name="password",value="111111")
//}

public class RegisterServlet extends HttpServlet {

    Connection con=null;
    public void init() throws ServletException {
//       ServletConfig config = getServletConfig();
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String username=request.getParameter("username");
          String password=request.getParameter("password");
          String email=request.getParameter("email");
          String gender=request.getParameter("gender");
          String birthDate=request.getParameter("birthDate");
//
//        PrintWriter writer=response.getWriter();
//        writer.println("<br>username :"+ username);
//        writer.println("<br>password :"+ password);
//        writer.println("<br>email :"+ email);
//        writer.println("<br>gender :"+ gender);
//        writer.println("<br>birthDate :"+ birthDate);
//        writer.close();
        String sql1="insert into Usertable values(?,?,?,?,?)";
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement(sql1);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,gender);
            pstmt.setString(5,birthDate);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html charset=utf-8");
        PrintWriter out=response.getWriter();
        String sql = "select * from usertable";
        try {
            ResultSet re = con.createStatement().executeQuery(sql);
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<td>"+"id"+"</td>");
            out.println("<td>"+"username"+"</td>");
            out.println("<td>"+"password"+"</td>");
            out.println("<td>"+"email"+"</td>");
            out.println("<td>"+"gender"+"</td>");
            out.println("<td>"+"birthdate"+"</td>");
            out.println("</tr>");
            while (re.next()) {

                out.println("<tr>");
                out.println("<td>"+re.getInt("id")+"</td>");
                out.println("<td>"+re.getString("username")+"</td>");
                out.println("<td>"+re.getString("password")+"</td>");
                out.println("<td>"+re.getString("email")+"</td>");
                out.println("<td>"+re.getString("gender")+"</td>");
                out.println("<td>"+re.getString("birthdate")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }



}