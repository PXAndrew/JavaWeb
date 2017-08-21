package com.scope;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/scope/result")
public class ReslutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();

        // result
        printWriter.print("request: " + req.getAttribute("NUM_IN_REQUEST"));

        // session
        printWriter.print("</br>session: " + req.getSession().getAttribute("NUM_IN_SESSION"));

        // servlet context
        printWriter.print("</br>application: " + req.getServletContext().getAttribute("NUM_IN_APPLICATION"));



    }
}
