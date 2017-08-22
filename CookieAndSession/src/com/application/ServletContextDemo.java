package com.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/application")
public class ServletContextDemo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取 servletContext 的三种方法
        ServletContext servletContext = super.getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        ServletContext servletContext2 = req.getSession().getServletContext();

        // 根据一个 web 的相对路径 获取它的绝对路径
        String realPath = super.getServletContext().getRealPath("/WEB-INF/in.html");
        // 获取上下文路径
        super.getServletContext().getContextPath();

        // 获取全局变量
        System.out.println(super.getServletContext().getInitParameter("encoding"));
        // 获取当前 servlet 的初始化变量
        System.out.println(super.getInitParameter("encoding"));

        // 获取所有的全局初始化变量
        System.out.println(super.getServletContext().getInitParameterNames());
    }
}
