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

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("USER_IN_SESSION");

//        String username = req.getSession();
        printWriter.print("欢迎"+ user.name +"</br>");
        printWriter.print("邮件");

    }
}
