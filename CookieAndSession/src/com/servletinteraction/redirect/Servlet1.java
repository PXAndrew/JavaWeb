package com.servletinteraction.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();

        System.out.println("servlet1");
        printWriter.print("servlet1......");

        System.out.println("servlet before");


        resp.sendRedirect("servlet2");          // 小心  跟 forward 的 参数 有所不同。。（有坑）


        System.out.println("servlet after");
    }


    /**
     * 重定向的特点
     * 1.浏览器地址发生改变
     * 2.URL重定向发了两次请求
     * 3.因为URL重定向是两次独立的请求，所以不共享请求中的数据。
     * 4.最终响应的东西由 sevlet2 来决定，相当于把 servlet2 的资源URL放到浏览器中敲回车
     * 5.URL 重定向可以跨域访问。
     * 6. URL 重定向不能访问 WEB-INF中的资源
     *
     */



}
