package com.andrew.extend;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

abstract public class MyGeneralHttpServlet extends MyGeneralService {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;

        service(httpServletRequest, httpServletResponse);

    }

    // 方法重载
    public void service(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {

        String method = request.getMethod(); // 获取请求方式
        System.out.println(method);

        if ("GET".equals(method)) {
            doGet(request, response);

        } else if ("POST".equals(method)) {
            doPost(request, response);

        }

    }

    // 用于处理 Get 请求
    abstract public void doGet(HttpServletRequest request, ServletResponse response);

    // 用于处理 POST 请求
    abstract public void doPost(HttpServletRequest request, ServletResponse response);
}
