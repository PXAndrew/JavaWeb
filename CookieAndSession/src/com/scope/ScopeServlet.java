package com.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scope/servlet")
public class ScopeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // request
        // 生命周期 每次请求
        Integer numInRequest = (Integer) req.getAttribute("NUM_IN_REQUEST");
        if (numInRequest == null) {
            req.setAttribute("NUM_IN_REQUEST", 1);
        } else {
            req.setAttribute("NUM_IN_REQUEST", numInRequest + 1);

        }

        // session
        // 浏览器的打开和关闭
        Integer numInSession = (Integer) req.getSession().getAttribute("NUM_IN_SESSION");
        if (numInSession == null) {
            req.getSession().setAttribute("NUM_IN_SESSION", 1);
        } else {
            req.getSession().setAttribute("NUM_IN_SESSION", numInSession + 1);
        }

        // servletContext(application)
        // 服务器的run 和 stop
        Integer numInApplication = (Integer) req.getServletContext().getAttribute("NUM_IN_APPLICATION");
//
        if (numInApplication == null) {
            req.getServletContext().setAttribute("NUM_IN_APPLICATION", 1);
        } else {
            req.getServletContext().setAttribute("NUM_IN_APPLICATION", numInApplication + 1);
        }

        req.getRequestDispatcher("/scope/result").forward(req, resp);



    }
}
