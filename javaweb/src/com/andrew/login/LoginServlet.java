package com.andrew.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /**
         * tomcat 默认编码为 "ISO-8859-1" 编码
         * 如果出现中文  GET 和 POST 请求的通用解决方案为 先通过 ISO-8859-1 编码转换为 byte[] 串
         * 再把 byte[] 重新编码成 UTF-8
         */
        req.setCharacterEncoding("UTF-8");
        /**
         * post 请求 可以使用 req.setCharacterEncoding("UTF-8") 方法 修改编码问题
         * get 请求 可以修改 tomcat下 conf/service.xml配置文件解决
         */
    }
}
