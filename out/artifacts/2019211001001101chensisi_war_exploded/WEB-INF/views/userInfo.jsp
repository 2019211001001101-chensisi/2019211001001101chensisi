<%@ page import="com.chensisi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/4/14
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<html>
<head>
    <title>userInfo</title>
</head>
<body>
<h1>User Info</h1>
<%User u=null;
    if(session.getAttribute("userInfo")!=null) {
        u= (User) session.getAttribute("userInfo");

    }
    if(session.getAttribute("userInfo")==null&&session.getAttribute("user")!=null) {
        u = (User) session.getAttribute("user");

    }
%>
<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td><tr/>
        <td>Password:</td><td><%=u.getPassword()%></td><tr/>
        <td>Email:</td><td><%=u.getEmail()%></td><tr/>
        <td>Gender:</td><td><%=u.getGender()%></td><tr/>
        <td>Birth Date:</td><td><%=u.getBirthdate()%></td><tr/>
    </tr>
    <a href="updateUser">Update User</a> </tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>
