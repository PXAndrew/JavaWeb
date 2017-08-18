package com.andrew.regist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regServlet")
public class RegistServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RegistServlet");

        String username = req.getParameter("username");
        String password  = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbys = req.getParameterValues("hobby");
        String city = req.getParameter("city");

        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(hobbys);
        System.out.println(city);






    }
}
