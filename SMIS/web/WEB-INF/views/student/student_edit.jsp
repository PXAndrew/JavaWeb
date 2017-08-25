<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/25
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/save" method="post">
        <input type="hidden" name="id" value="${student.id}"/>
        姓名：<input type="text" name="name" value="${student.name}" required/><br>
        年龄：<input type="number" name="age" value="${student.age}" required/><br>
        <br>
        <input type="submit" value="${student == null ? "保存学生信息" : "更新学生信息"}">
    </form>
</body>
</html>
