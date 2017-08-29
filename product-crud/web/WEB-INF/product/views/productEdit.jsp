<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 2017/8/27
  Time: 下午10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductEdit</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/product?cmd=update" method="post">
        <input type="hidden" name="id" value="${requestScope.product.id}"/>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td>货品名称</td>
                <td><input type="text" name="productName" value="${requestScope.product.productName}" required/></td>
            </tr>
            <tr>
                <td>货品品牌</td>
                <td><input type="text" name="brand" value="${requestScope.product.brand}" required/></td>
            </tr>
            <tr>
                <td>供应商</td>
                <td><input type="text" name="supplier" value="${requestScope.product.supplier}" required/></td>
            </tr>
            <tr>
                <td>零售价</td>
                <td><input type="number" name="salePrice" min="0" value="${requestScope.product.salePrice}" required/></td>
            </tr>
            <tr>
                <td>成本价</td>
                <td><input type="number" name="costPrice" min="0" value="${requestScope.product.costPrice}" required/></td>
            </tr>
            <tr>
                <td>折扣</td>
                <td><input type="text" name="cutoff" value="${requestScope.product.cutoff}" required/></td>
            </tr>
            <tr>
                <td>货品分类</td>
                <td>
                    <select name="dir_id">
                        <c:forEach items="${requestScope.dirs}" var="dir">
                            <option value="${dir.id}" ${requestScope.product.productDir.id == dir.id ? "selected" : ""}>${dir.dirName}</option>
                        </c:forEach>>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="保存"></td>
            </tr>
        </table>

    </form>
</body>
</html>
