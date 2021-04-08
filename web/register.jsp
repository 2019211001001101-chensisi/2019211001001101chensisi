<%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/3/23
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
This is my register JSP page. <br/>

<form method="post" action="Register" >
     <br/>
    username:<input type="text" name="username" /><br/>
    password:<input type="password" name="password"/><br/>
    email:<input type="text" name="email" /><br/>
    Gender<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/>
    Date of Birth:<input type="text"  name="birthDate"><br/>
    <input type=submit value="Register"/>
    <%@include file="footer.jsp"%>
</form>
</body>
</html>
