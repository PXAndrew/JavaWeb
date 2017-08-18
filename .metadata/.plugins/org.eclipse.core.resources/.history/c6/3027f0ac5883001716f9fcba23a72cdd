package com.andrew.extend;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class Servlet1 extends MyGeneralHttpServlet {


    @Override
    public void doGet(HttpServletRequest request, ServletResponse response) {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, ServletResponse response) {
        System.out.println(request);
    }
}
