<%@ page import="java.util.List" %>
<%@ page import="JDBC.student.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/22
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
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
</head>
<body>

</body>
</html>
