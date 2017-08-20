package com.andrew.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessiongetemail")
public class SessionGetEmail extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        String username = null;

        HttpSession httpSession = req.getSession();
        username = (String) httpSession.getAttribute("username");
//        String username = req.getSession()
        printWriter.print("欢迎"+ username +"</br>");
        printWriter.print("邮件");

    }
}
