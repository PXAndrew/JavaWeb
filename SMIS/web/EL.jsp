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
    <%=pageContext.findAttribute("msg")%><br>

    <%=pageContext.findAttribute("msg")==null?"":pageContext.findAttribute("msg")%><br>
    <%--下面这个表达式等价于上面这一行  获取共享数据  转变成一种语法--%>
    ${msg}<br>
    <%--获取当前请求中 参数名字为 username 的参数值--%>
    username = ${param.username}<br>
    <%--EL 中的四大作用于对象  使用 EL 获取不能作用域的属性值--%>
    <%--从 session 中去找 msg 数据--%>
    ${pageScope.msg}<br>
    ${requestScope.msg}<br>
    ${sessionScope.msg}<br>
    ${applicationScope.msg}<br>

    <h3>获取对象信息</h3>
    <%--获取对象中的属性，用的都是 getter 方法--%>
    username:${p.username}-->${p["username"]}-->${p.getUsername()}<br>
    age:${p.age}<br>
    hobbys:${p.hobbys[1]}<br>
    list:${p.list[1]}<br>
    map:${p.map.company}<br>
    <%--因为后面的 www.baidu.com 中有'.' 和 EL 语法中的'.' 冲突, 所以用下面这种方法--%>
    map:${p.map["www.baidu.com"]}<br>
    <h3>获取上下文路径</h3><br>
    <%--上下文路径就是 配置文件中 path 属性里的东西--%>
    <%=request.getContextPath()%><br>
    ${pageContext.getRequest().getContextPath()}<br>
    ${pageContext.request.contextPath}<br>
    <h3>运算</h3>
    \${1 + 3 / 2} = ${1 + 3 / 2}<br>
    <h3>向当前作用域设置共享数据</h3>
    <%
        pageContext.setAttribute("list", new java.util.ArrayList());
    %>
    <%--判断 list 的内容是否为空，而不是 list 的引用是否为空--%>
    ${empty list}<br>

    <h3>做判断</h3><br>
    <%--比较的是内容，而不是地址--%>
    ${1 == 1}<br>
    ${1 eq 1}<br>
    <%--从 tomcat 7 开始，可以支持在EL语法中调用方法--%>

<%--tomcat 7 开始，可以通过对象创建方法--%>




</body>
</html>
