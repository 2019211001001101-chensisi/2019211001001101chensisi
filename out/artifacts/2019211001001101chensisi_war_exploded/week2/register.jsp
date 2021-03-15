<%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/3/14
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get and Post Demo</title>
<body>
<form method="Post" action="">
    <br/>
    Username:<input type="text" name="Username" size="20" required><br/>
    password:<input type="password" name="password" size="20" minlength="8" required><br/>
    email:<input type="text" name="email" required ><br/>
    Gender
    <input type="radio" name="sex">Male
    <input type="radio" name="sex">Female
    <br/>
    Birthday:
    <input type="text"  name="birthday" value="${dateTest}"var="dateTest" value="${xxx}" pattern="yyyy-MM-dd HH:mm:ss"  >
    <br/>
    <input type=submit value="Register"/>
</form>
</body>
</html>
