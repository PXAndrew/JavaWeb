package com.andrew.param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/paramshowlist")
public class ParamShowList extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String username = req.getParameter("username");
        printWriter.print("欢迎" + username + "</br>");
        printWriter.print("收件箱</br>");
        printWriter.print("<a href='/paramapp/paramgetemail?username=" + username + "'>邮件</a></br>");
        printWriter.print("<a href='/paramapp/paramgetemail?username=" + username + "'>邮件</a></br>");
        printWriter.print("<a href='/paramapp/paramgetemail?username=" + username + "'>邮件</a></br>");
        printWriter.print("<a href='/paramapp/paramgetemail?username=" + username + "'>邮件</a></br>");
        printWriter.print("<a href='/paramapp/paramgetemail?username=" + username + "'>邮件</a></br>");
        System.out.println("/paramapp/paramshowlist");

    }
}
