<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
    import 就相当于 servlet 中的 import
 -->
<%--
  Created by IntelliJ IDEA.
  User: Andrew-S-Loptop
  Date: 2017/8/22
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" errorPage="/JSPDemo/errorDemo.jsp" %>

<!--
errorPage 属性 为本页面出现异常 请求转发的 jsp 路径
-->

<!--
    特点
    1. 不向客户端输产生任何输出
    2. 指令在 JSP 整个文件范围内有效
    3. 为翻译阶段提供全局信息

    JSP 的三大指令
    page: 表示 JSP 页面的相关配置信息
        language: 表示 jsp 中编写脚本的语言  只支持 java
        contentType: 表示 jsp 输出的 memo 类型和编码  等价于 resp.setContentType("text/html; charset = UTF-8")
        pageEncoding: 表示 jsp 输出的编码      resp.setCharacterEncoding("UTF-8")

        若 contentType 和 pageEncoding 共存，以 contentType 以 contentType 为准
    include:

    taglib:
-->

<!--
    JSP 内置对象
    对象                     对象类型                             描述
    request                 HttpServletRequest                  请求对象
    response                HttpServletResponse                 响应对象
    pageContext             PageContext                         当前 JSP 作用域
    session                 HttpSession                         session
    exception               Throwable                           异常 （page 指令 isErrorPage="true"）
    application             ServletContext                      当前 WEB 应用对象
    config                  ServletConfig                       当前 servlet 的信息配置对象
    out                     JspWriter                           字符输出流对象
    page                    Object                              本身 JSP 对象
-->

<!--
    JSP 的 四大作用域
    对象                         对象类型                             描述
    pageContext                 PageContext                         当前 JSP 作用域
    request                     HTTPServletRequest                  请求作用域
    session                     HttpSession                         会话作用域
    application                 ServletContext                      当前整个项目 从 Tomcat 启动到关闭
-->

<html>
<head>
    <title>Title</title>
</head>
<body>

    <!-- html 的注释，会被翻译到 tomcat 的servlet 中去，仅仅就是浏览器不 -->
    <%-- jsp 的注释，不会被玩意到 servlet 中 --%>

    <%
        // java 代码
        String name = "jiaojian";
        List list = new ArrayList();
        int a = 1 / 0;

    %>
    <%-- 输出 java 变量 --%>
    <%=name%>

    <%!
        // 声明成员变量 和 方法
        private String jjj;

        public void test() {
            System.out.println(jjj);
        }
    %>
    <!-- 动作元素 请求转发 -->
    <jsp:forward page="errorDemo.jsp">
        <jsp:param name="asdf" value="ssss"/>
    </jsp:forward>

    hello world
</body>
</html>
