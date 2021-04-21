<%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/4/6
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Login</h1> <br/>
<%
if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"</h3>");
}
%>
<form method="post" action="login">
<table>
    <tr> <td>username:</td> <td><input type="text" name="username" required><br/></td></tr>
    <tr> <td>password:</td> <td><input type="password" name="password" ><br/></td></tr>
    <tr> <td></td><td><input type="submit" value="Login"/></td>  </tr>
</table>
</form>
<%@include file="footer.jsp"%>
</body>
</html>
