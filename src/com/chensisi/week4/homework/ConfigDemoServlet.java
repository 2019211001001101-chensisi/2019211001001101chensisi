package com.chensisi.week4.homework;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns ={"/config"},
        initParams={
                @WebInitParam(name="name",value="chensisi"),
                @WebInitParam(name="studentid",value="2019211001001101")
        }
)
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name = getServletConfig().getInitParameter("name");
        String studentid = getServletConfig().getInitParameter("studentid");
        PrintWriter writer=response.getWriter();
        writer.println("name: chensisi");
        writer.println("studentid:2019211001001101");
    }
}
