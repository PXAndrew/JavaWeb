package com.servletinteraction.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forward/servlet1")
public class Servlet1 extends Servlet2 {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();

        System.out.println("servlet1");
        printWriter.print("servlet1......");

        System.out.println("servlet before");

        req.getRequestDispatcher("/forward/servlet2").forward(req, resp);

        System.out.println("servlet after");
    }

    /**
     * 请求转发
     * 从 servlet1 完成一部分功能，再在 servlet2 完成另一部分功能
     *
     * 如果 servlet 的 request 对象中有参数，会连带着参数一起传递给 servlet2
     *
     * 流程就是请求到 servlet1 然后 servlet1 把请求相当于包装了一层，传递给 servlet2。 所以他们共享数据
     * servlet2 接收到请求之后，处理业务逻辑，然后把响应返回到 servlet1，然后再从 servlet1 返回到客户端
     *
     * 请求转发的地址，如果前面加 '/' 如 /forward/servlet2。
     * 这个第一个 / 相当于 web 的路径 （web 的跟路径）
     * 如果前面不加 '/' 如 forward/servlet2
     * 相当于 访问的请求的最后一个 / 后面 加上 forward/servlet2
     *
     * 比如 http://localhost:8080/param/forward/servlet2
     *
     * 项目根路径为 http://localhost:8080/param （tomcat 配置文件中配置的）
     * 前面加 '/' 如 /forward/servlet2： 转发地址为 http://localhost:8080/param/forward/servlet2 （通常用这种）
     * 若不加 '/' 如 forward/servlet2: 转发地址为 http://localhost:8080/param/forward/forward/servlet2
     * 所以，请求转发不能跨域跳转，只能在当前项目的目录下
     *
     * 正常情况下，客户端是不能访问 WEB-INF 下的资源。 但是 forward 可以访问 WEB-INF 下的资源。
     *
     */
}
