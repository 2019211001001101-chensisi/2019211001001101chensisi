package com.chensisi.week3.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    Connection con=null;
    public void init() throws ServletException {
//        String driver = getServletContext().getInitParameter("driver");
//        String url = getServletContext().getInitParameter("url");
//        String username = getServletContext().getInitParameter("username");
//        String password = getServletContext().getInitParameter("password");
//        try {
//            Class.forName(driver);
//             con = DriverManager.getConnection(url, username, password);
//            System.out.println("init()-->"+con);
//        } catch (ClassNotFoundException| SQLException e) {
//            e.printStackTrace();
//        }
        con=(Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //int id= Integer.parseInt(request.getParameter("id"));
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
        try {
            String sql ="userdb insert into usetable(username,password,email,gender,birthdate) values(?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(sql);
            //pstmt.setInt(1, id);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, gender);
            pstmt.setString(5, birthDate);
            pstmt.executeUpdate();
            // PrintWriter out=response.getWriter();
//            String sql1 = "select * from usertable ";
//            ResultSet re = createDbStatement.executeQuery(sql1);
//            out.println("<table border='1' align='center'>");
//            out.println("<tr>");
//            out.println("<td>"+"id"+"</td>");
//            out.println("<td>"+"username"+"</td>");
//            out.println("<td>"+"password"+"</td>");
//            out.println("<td>"+"email"+"</td>");
//            out.println("<td>"+"gender"+"</td>");
//            out.println("<td>"+"birthdate"+"</td>");
//            out.println("</tr>");
//            while (re.next()) {
//                out.println("<tr>");
//                out.println("<td>"+re.getString("id")+"</td>");
//                out.println("<td>"+re.getString("username")+"</td>");
//                out.println("<td>"+re.getString("password")+"</td>");
//                out.println("<td>"+re.getString("email")+"</td>");
//                out.println("<td>"+re.getString("gender")+"</td>");
//                out.println("<td>"+re.getString("birthdate")+"</td>");
//                out.println("</tr>");
//            }
//            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("login");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }



}