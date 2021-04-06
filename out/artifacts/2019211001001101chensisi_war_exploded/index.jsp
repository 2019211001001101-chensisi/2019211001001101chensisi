<%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/3/10
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="gb2312" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP-Hello World</title>
</head>
<%@include file="header.jsp"%>

<h1><%="Welcome to my home page"%></h1>
<body>
<br/>
<a href="hello-servlet">Hello Servlet-week1</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="Life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">Config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC-week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="Login.jsp">Login-week5</a>
<br/>
<%@include file="footer.jsp"%>
</body>
</html>
