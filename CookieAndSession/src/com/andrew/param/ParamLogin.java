package com.andrew.param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/paramlogin")
public class ParamLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");  // 设置请求编码，只对 post 有效
        resp.setContentType("text/html;charset=utf-8"); // 设置输出编码和 mimetype 类型
        // 获取输出流
        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("username");


        printWriter.print("欢迎" + username + "</br>");
        printWriter.print("<a href='paramshowlist?username=" + username + "'>收件箱</a>");


    }
}
