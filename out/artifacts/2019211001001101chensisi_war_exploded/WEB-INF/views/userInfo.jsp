<%@ page import="com.chensisi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/4/14
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfo</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User)request.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
        <td>Password:</td><td><%=user.getPassword()%></td>
        <td>Email:</td><td><%=user.getEmail()%></td>
        <td>Gender:</td><td><%=user.getGender()%></td>
        <td>Birth Date:</td><td><%=user.getBirthdate()%></td>
    </tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>
