package com.chensisi.controller;

import com.chensisi.dao.UserDao;
import com.chensisi.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")

public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();

        con=(Connection)getServletContext().getAttribute("con");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date birthdate =Date.valueOf(request.getParameter("birthdate"));
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        User user=new User(id,username,password,email,gender,birthdate);

        UserDao userDao= new UserDao();
        try {
            int n= userDao.updateUser(con,user);
            if(n==1) {
                HttpSession session=request.getSession();
                session.setAttribute("userInfo", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            }else {
                System.out.println("update error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao UserDao = new UserDao();
        try {
            User r = UserDao.findById(con,id);
            HttpSession session=request.getSession();
            session.setAttribute("userInfo", r);
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();

        }








    }
}

