package com.servletinteraction.include;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/include/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();

        System.out.println("servlet1");
        printWriter.print("servlet1......");

        System.out.println("servlet1 before");

        req.getRequestDispatcher("/forward/servlet2").include(req, resp);

        System.out.println("servlet1 after");
        printWriter.print("servlet1 after");
    }

    /**
     * 包含
     * 一般用于 jsp 中
     * 共享参数
     */

}
