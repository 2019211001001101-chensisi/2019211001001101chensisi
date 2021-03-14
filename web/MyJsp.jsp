<%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/3/12
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get and Post Demo</title>
</head>
<body>
<a href="index.jsp">Get Home page</a><! -- What is method Get or post-->
<form method="post">
    <! --What is method Get or post -->
    <! --Get , Why ? default is GET -->
    <! --if you want to use post , u need write method = post-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    password:<input type="text" name="password"><br/>
    <input type="submit" value="Post data to server"/>

</form>
</body>
</html>
