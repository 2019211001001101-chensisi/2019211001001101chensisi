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
<%User r=null;
    if(session.getAttribute("userInfo")!=null) {
        r= (User) session.getAttribute("userInfo");

    }
    if(session.getAttribute("userInfo")==null&&session.getAttribute("user")!=null) {
        r = (User) session.getAttribute("user");

    }
%>
<table>
    <tr>
        <td>Username:</td><td><%=r.getUsername()%></td>
        <td>Password:</td><td><%=r.getPassword()%></td>
        <td>Email:</td><td><%=r.getEmail()%></td>
        <td>Gender:</td><td><%=r.getGender()%></td>
        <td>Birth Date:</td><td><%=r.getBirthdate()%></td>
    </tr>
    <a href="updateUser">Update User</a> </tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>
