package com.chensisi.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request , HttpServletResponse response)
          throws IOException {
        PrintWriter writer=response.getWriter();
        writer.println("Name: chensisi");
        writer.println("ID:20192111001001101");
        Date date=new Date();
        writer.println("Date and time: "+date.toString());
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response){

    }
}
