<%@page import="com.chensisi.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/4/28
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
    User u=null;
    if(session.getAttribute("userInfo")!=null) {
        u = (User) session.getAttribute("userInfo");
        pageContext.setAttribute("userInfo",u);
    }
%>

<form method="post" action="updateUser" >
    <br/>
    id:<input type="text" name="id" value="<%=u.getId()%>" /><br>
    username:<input type="text" name="username" value="<%=u.getUsername()%>" /><br/>
    password:<input type="password" name="password" value="<%=u.getPassword()%>" /><br/>
    email:<input type="text" name="email" value="<%=u.getEmail()%>" /><br/>
    Gender<input type="radio" name="gender" value="male"<%="male".equals(u.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female"  <%="female".equals(u.getGender())?"checked":""%>>Female<br/>
    Date of Birth:<input type="text"  name="birthDate",value="<%=u.getBirthdate()%>" /><br/>
    <input type="submit" value="Register"/>
</form>
<%
    session.setAttribute("userInfo",u);
%>
<%@include file="footer.jsp"%>