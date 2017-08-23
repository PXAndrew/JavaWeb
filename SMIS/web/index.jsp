<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/22
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

    <%

        // jsp 四大作用域
        pageContext.setAttribute("msg", "pageContextValue");
        request.setAttribute("msg", "requestValue");
        session.setAttribute("msg", "sessionValue");
        application.setAttribute("msg", "applicationValue");
    %>
    <%--获取出每一个作用域的属性--%>
    pageContext:  <%=pageContext.getAttribute("msg")%> <br>
    request:  <%=request.getAttribute("msg")%> <br>
    session:  <%=session.getAttribute("msg")%> <br>
    application:  <%=application.getAttribute("msg")%> <br>
    <%--下面这个方法是从四大作用域中最小的作用域开始查找--%>
    <%=pageContext.findAttribute("msg")%>


</body>
</html>
