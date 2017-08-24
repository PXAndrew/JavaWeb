<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/24
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%--
导入 lib 文件之后，一定要重启 tomcat
一定要导入
el-api.jar                  // el api
jsp-api.jar                 // jsp api
servlet-api.jar             // servlet jar
taglibs-standard-impl.jar   // jstl 实现
taglibs-standard-spec.jar   // jstl 接口
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <%
        pageContext.setAttribute("num", 10);
    %>
    <%--满足条件就输出标签中的内容--%>
    <c:if test="${num > 20}">
        num > 20
    </c:if>
    <br>

    <%--把存储结果存在一个变量中--%>
    <c:if test="${num > 20}" var="result" scope="page"/>

    ${result}<br>

    <c:choose>
        <c:when test="${num > 20}">num > 20</c:when>
        <c:when test="${num < 20}">num < 20</c:when>
        <c:otherwise>num = 20</c:otherwise>
    </c:choose>
    <br>


    <%--
        begin 起始位置
        stop 终止位置
        step 步长
        var 变量
        num 是存放在 pageContext 中。
    --%>
    <c:forEach var="num" begin="1" end="10" step="1">
        ${num}
    </c:forEach>
    <br>




</body>
</html>
