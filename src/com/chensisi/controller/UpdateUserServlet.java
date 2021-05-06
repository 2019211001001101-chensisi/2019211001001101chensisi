package com.chensisi.controller;

import com.chensisi.dao.UserDao;
import com.chensisi.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;

@WebServlet(name = "UpdateUserServlet",value = "/update")

public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();

        con=(Connection)getServletContext().getAttribute("con");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date Birthdate =Date.valueOf(request.getParameter("birthDate"));
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("Username");
        String password = request.getParameter("password");
        String email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        User user=new User(id,username,password,email,gender,Birthdate);

        UserDao userDao= new UserDao() {
            @Override
            public User findById(Connection con, Integer id) throws SQLException {
                return null;
            }
        };

        try {
            int n= userDao.updateUser(con,user);
            if(n==1) {

                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            }else {
                System.out.println("update error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    }

