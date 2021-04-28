<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 19462
  Date: 2021/4/6
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    if(request.getAttribute("message") != null)
    {
        out.println("<h3 >"+request.getAttribute("message")+"</h3>");
    }
%>
<%
    Cookie allCookies[]=request.getCookies();
    String username="";String password="";String rememberMeval="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if("cUsername".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                username= URLDecoder.decode(c.getValue(),"utf-8");
            }
            if("cPassword".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                password=URLDecoder.decode(c.getValue(),"utf-8");
            }
            if("cRememberMe".equals(URLDecoder.decode(c.getName(),"UTF-8"))){
                rememberMeval=URLDecoder.decode(c.getValue(),"utf-8");
            }
        }
    }
%>
<form method="post" action="login">
    Username:<input type="text" name="name" value="<%=username%>"/><br/>
    Password:<input type="password" name="password" value="<%=password%>"/><br/>
    <input type="checkbox" name="rememberMe" value="1" <%="1".equals(rememberMeval)?"checked":""%>/>RememberMe<br>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
</html>
