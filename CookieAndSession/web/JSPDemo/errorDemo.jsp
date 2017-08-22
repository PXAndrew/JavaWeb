<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/22
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%--
    isErrorPage 属性 为 true 时 ，能拿到 exception 对象。如果为 false ，则拿不到 exception 对象。
 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    出现信息:<%=exception.getMessage()%>
</body>
</html>
