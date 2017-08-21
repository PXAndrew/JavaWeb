package com.andrew.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionlogin")
public class SessionLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");  // 设置请求编码，只对 post 有效
        resp.setContentType("text/html;charset=utf-8"); // 设置输出编码和 mimetype 类型
        // 获取输出流
        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("username");


        /**
         *
         * session 是一种特殊的 cookie
         * 它会在服务器申请一块内存，存放数据，并把地址通过 cookie 返还给客户端
         * 下次客户端就通过这个 地址来访问服务器，获取缓存的数据
         * session 翻译过来的意思就是会话，也就是 cookie 的会话属性
         *
         * // 如果当前请求存在一个 session 就返回，如果没有存在就创建一个 session
         * HttpSession httpSession = req.getSession(true);
         * // 如果当前请求中存在一个 session 就返回，如果不存在就返回一个 null
         * HttpSession httpSession = req.getSession(false);
         * // 默认情况下是 HttpSession httpSession = req.getSession(true);
         * HttpSession httpSession = re q.getSession();
         */

        User user = new User();
        user.setName(username);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("USER_IN_SESSION", user);

        // 删除 session 中的某个属性 (注销登录)
        httpSession.removeAttribute("xxxx");
        // 销毁 session
//        httpSession.invalidate();

        // session 的超时管理 （用户的两次操作不能超过该时间）  超过该时间 session 销毁
        // tomcat 默认超时时间为 30分钟 在conf/web.xml 设置，也可在项目中 web.xml 中设置自己项目的超时时间
//        httpSession.setMaxInactiveInterval(15);

        // 如果浏览器禁用 cookie，可以在http地址后面拼接
        // http://localhost/xxxx/xxxx;jsessionid=xxxxxxx
        // 开发中一般出现这种请情况
        String url = resp.encodeURL("sessionshowlist");


        printWriter.print("欢迎" + username + "</br>");
        printWriter.print("<a href='"+ url +"'>收件箱</a>");
    }

    /**
     * session 规范
     * 1.一般的，我们存储到 session 要唯一，我们习惯 XXX_IN_SESSION
     * 例如        httpSession.setAttribute("USERNAME_IN_SESSION", username);
     * 2. 需要多个数据时，可以把多个数据封装成一个对象。然后传给后台。。session 可以存储复杂数据， cookie 只能存储 string 类型数据
     * 这个对象要遵守 import java.io.Serializable; 接口。因为要在网络上传输。
     * 3. 如果多台服务器要共享 session，此时 session 必须实现 import java.io.Serializable 接口
     * 序列化：把对象转换成 二进制
     * 反序列化：把二进制转换成对象
     * 例如代码中所示
     */
}
