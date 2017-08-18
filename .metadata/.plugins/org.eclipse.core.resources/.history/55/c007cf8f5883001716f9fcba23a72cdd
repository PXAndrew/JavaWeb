package com.andrew.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/req")
public class HttpServletRequestDemo extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("HttpServletRequestDemo");
        // 获取请求方式 如 GET / POST
        System.out.println(req.getMethod()); // GET
        // 获取资源名称
        System.out.println(req.getRequestURI()); // /webapp/req
        // 返回地址栏所有的信息
        System.out.println(req.getRequestURL()); //http://localhost:8080/webapp/req
        // 获取当前项目的上下文路径
        System.out.println(req.getContextPath()); // /webapp
        // 获取客户端 IP 地址
        System.out.println(req.getRemoteAddr()); // 0:0:0:0:0:0:0:1
        // 返回指定名称请求头的值
        System.out.println(req.getHeader("User-Agent"));
        // 返回指定参数名字的值
        System.out.println(req.getParameter("username"));
        // 返回指定参数名的多个参数值
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbys));
        // 返回所有参数名的 Enumeration 对象
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            System.out.println(paramName);
        }
        // 返回所有参数的 MAP对象
        Map<String, String[]> params = req.getParameterMap();
        System.out.println(params.toString());



    }
}
