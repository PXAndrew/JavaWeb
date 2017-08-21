package com.andrew.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookieshowlist")
public class CookieShowList extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String username = null;
        Cookie[] cookies = req.getCookies();
        // 获取 cookie
        if (cookies != null) {
            for (Cookie cookie :
                    cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
            }
        }


        printWriter.print("欢迎" + username + "</br>");
        printWriter.print("收件箱</br>");
        printWriter.print("<a href='/cookiegetemail'>邮件</a></br>");
        printWriter.print("<a href='/param/cookiegetemail'>邮件</a></br>");
        printWriter.print("<a href='/param/cookiegetemail'>邮件</a></br>");
        printWriter.print("<a href='/param/cookiegetemail'>邮件</a></br>");
        printWriter.print("<a href='/param/cookiegetemail'>邮件</a></br>");

    }
}
