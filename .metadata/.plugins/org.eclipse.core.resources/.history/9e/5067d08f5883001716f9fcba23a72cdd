package com.andrew.hello;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet {

    // 构造器一定要使用 public

    /**
     * 底层创建 servlet 对象使用的是 Class.newInsetence() 方法 -> 这方法要保证有一个 共有的无参数构造器
     */
    public HelloServlet() {

    }

    // 初始化 servlet 对象方法
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    // 获取 servlet 的配置信息对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 服务方法：web 动态网页的操作编写就在该方法
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("hello world!");
        System.out.println("aaaaa");
    }

    // 获取 servlet 信息
    @Override
    public String getServletInfo() {
        return null;
    }

    // 销毁 servlet 对象的方法
    @Override
    public void destroy() {

    }
}

