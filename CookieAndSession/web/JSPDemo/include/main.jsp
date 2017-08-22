<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/22
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IncludeDemo</title>
</head>
<body>
    <%--
        静态包含就是在翻译阶段，就把文件合并在一起，翻译的结果只有一个 main.java 文件
    --%>
    <%--<%@include file="/JSPDemo/include/header.jsp"%>--%>

    <%--动态包含，翻译还是翻译成三个文件，在字节码运行时合并在一起--%>
    <%--在需要传递数据的时候一定要使用动态包含--%>
    <jsp:include page="header.jsp">
        <jsp:param name="name" value="value"/>
    </jsp:include>
    <br>
    动态代码
    <br>
    <%@include file="/JSPDemo/include/footer.jsp"%>
</body>
</html>
