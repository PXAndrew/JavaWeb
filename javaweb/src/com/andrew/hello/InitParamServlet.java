package com.andrew.hello;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class InitParamServlet implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println(encoding);

        Enumeration<String> enumeration= servletConfig.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            System.out.println(servletConfig.getInitParameter(key));
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
