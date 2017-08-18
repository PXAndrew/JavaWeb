package com.andrew.extend;

import javax.servlet.*;


import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

abstract public class MyGeneralService implements Serializable, Servlet, ServletConfig {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        init();
    }

    // 这个方法供给子类调用
    public void init() {
        // no implements
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    abstract public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    // -----------------------------------------------------------------------
    @Override
    public String getServletName() {
        return servletConfig.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    @Override
    public String getInitParameter(String name) {
        return servletConfig.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return servletConfig.getInitParameterNames();
    }
}