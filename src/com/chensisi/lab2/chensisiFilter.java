package com.chensisi.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ChenSiSiFilter",urlPatterns = "/lab2/welcome.jsp")
public class ChenSiSiFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("ChenSiSiFilter-->before chain");
        chain.doFilter(request, response);
        System.out.println("ChenSiSiFilter-->after chain");
    }
}