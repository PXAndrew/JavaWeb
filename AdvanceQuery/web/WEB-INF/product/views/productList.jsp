<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 2017/8/27
  Time: 上午10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ProductList</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/product?cmd=list" method="post">
    商品名称<input type="search" name="name" value="${productQueryObject.name}">
    零售价格<input type="number" name="minSalePrice" value="${productQueryObject.minSalePrice}">-
           <input type="number" name="maxSalePrice" value="${productQueryObject.maxSalePrice}">
            商品分类<select name="dirID">
                <option value="-1">全部分类</option>
                <c:forEach items="${dirs}" var="dir">
                    <option value="${dir.id}">${dir.dirName}</option>
                </c:forEach>
            </select>

           <input type="submit" value="查询">
</form>
<%--<a href="${pageContext.request.contextPath}/product?cmd=edit">添加商品</a>--%>
<table border="1" width="100%" cellpadding="0" cellspacing="0">
    <tr style="background-color: orange">
        <th>货品编号</th>
        <th>货品名称</th>
        <th>货品品牌</th>
        <th>货品零售价</th>
        <th>供应商</th>
        <th>品牌</th>
        <th>折扣</th>
        <th>成本价</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.products}" var="product" varStatus="vs">
        <tr style="background-color: ${vs.count % 2 == 0 ? "gray" : ""};">
            <th>${product.id}</th>
            <th>${product.productName}</th>
            <th>${product.productDir.dirName}</th>
            <th>${product.salePrice}</th>
            <th>${product.supplier}</th>
            <th>${product.brand}</th>
            <th>${product.cutoff}</th>
            <th>${product.costPrice}</th>
            <th>
                <a href="${pageContext.request.contextPath}/product?cmd=edit&id=${product.id}">编辑</a>      |
                <a href="${pageContext.request.contextPath}/product?cmd=delete&id=${product.id}">删除</a>
            </th>
        </tr>
    </c:forEach>

</table>


</body>
</html>
