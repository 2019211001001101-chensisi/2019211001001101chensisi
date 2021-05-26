package com.chensisi.week5.homework;

import com.chensisi.dao.UserDao;
import com.chensisi.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.*;

@WebServlet(name="LoginServlet",value="/login")

public class LoginServlet extends HttpServlet {
    Connection con=null;

    public void init() throws ServletException {
        super.init();
//        String driver=getServletConfig().getServletContext().getInitParameter("driver");
//        String url=getServletConfig().getServletContext().getInitParameter("url");
//        String username=getServletConfig().getServletContext().getInitParameter("username");
//        String password=getServletConfig().getServletContext().getInitParameter("password");
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url,username,password);
//            System.out.println("init()-->"+con);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
        con=(Connection)getServletContext().getAttribute("con");
    }

            protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//                request.setCharacterEncoding("utf-8");
//                response.setContentType("text/html;charset=utf-8");
                String UserName = request.getParameter("name");
                String PassWord = request.getParameter("password");
                PrintWriter out = response.getWriter();
                UserDao userDao = new UserDao();
                try {
                    User user = userDao.findByUsernamePassword(con,UserName,PassWord);
                    if (user != null) {
                        String rememberMe=request.getParameter("remember");
                        if("1".equals(rememberMe)&&rememberMe!=null){

                            Cookie passwordCookie=new Cookie("cPassword", URLEncoder.encode(user.getPassword(),"UTF-8"));
                            passwordCookie.setMaxAge(30*60);
                            response.addCookie(passwordCookie);
                            Cookie rememberMeCookie=new Cookie("cRememberMe", URLEncoder.encode(rememberMe,"UTF-8"));
                            rememberMeCookie.setMaxAge(30*60);
                            response.addCookie(rememberMeCookie);
                            Cookie usernameCookie=new Cookie("cUsername", URLEncoder.encode(user.getUsername(),"UTF-8"));
                            usernameCookie.setMaxAge(30*60);
                            response.addCookie(usernameCookie);
                        }
                        HttpSession session=request.getSession();
                        System.out.println("session id-->"+session.getId());
                        session.setMaxInactiveInterval(10);
                        session.setAttribute("user", user);
                        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
                    } else {
                        request.setAttribute("message", "username or password error");
                        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

//                try {
//                    String sql1 = "select * from usertable WHERE username='"+UserName+"' AND password='"+PassWord+"';";
//                    ResultSet rs =con.createStatement().executeQuery(sql1);
//                    if(rs.next()){
////                      out.println("Login Success!!!");
////                      out.println("Welcome "+UserName+".");
//                        request.setAttribute("id",rs.getString("id"));
//                        request.setAttribute("username",rs.getString("username"));
//                        request.setAttribute("password",rs.getString("password"));
//                        request.setAttribute("email",rs.getString("email"));
//                        request.setAttribute("gender",rs.getString("gender"));
//                        request.setAttribute("birthdate",rs.getString("birthdate"));
//                        request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//                    }
////                    else out.println("Login Error!!!");
//                    request.setAttribute("message","Username or Password Error!!!");
//                    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
    }


            protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            doPost(request,response);
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);


            }

}
