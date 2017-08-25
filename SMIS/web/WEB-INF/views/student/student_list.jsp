<%@ page import="java.util.List" %>
<%@ page import="JDBC.student.model.Student" %>



<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/22
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<a>
    <title>学生信息</title>
    <%--
    学生列表
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
    %>
    <table border="1" width="80%" cellpadding="0" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
        </tr>
        <%
            for (Student student :
                    students) {
        %>
        <tr>
            <td><%=student.getId() %></td>
            <td><%=student.getName() %></td>
            <td><%=student.getAge() %></td>
        </tr>
        <%
            }
        %>
    </table>
    --%>

    <a href="${pageContext.request.contextPath}/student/edit">添加学生</a>

    <table border="1" width="60%" cellpadding="0" cellspacing="0">
        <tr style="background-color: orange">
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
            <th>Operation</th>
        </tr>
        <c:forEach items="${requestScope.students}" var="student" varStatus="vs">
        <tr style="background-color: ${vs.count % 2 == 0 ? "gray" : ""};">
            <th>${student.id}</th>
            <th>${student.name}</th>
            <th>${student.age}</th>
            <th>
                <a href="${pageContext.request.contextPath}/student/edit?id=${student.id}">编辑</a>      |
                <a href="${pageContext.request.contextPath}/student/delete?id=${student.id}">删除</a>
            </th>
        </tr>
        </c:forEach>

    </table>


    <br>

</head>
<body>

</body>
</html>
