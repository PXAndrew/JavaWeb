package com.andrew.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/cookielogin")
public class CookieLogin extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");  // 设置请求编码，只对 post 有效
        resp.setContentType("text/html;charset=utf-8"); // 设置输出编码和 mimetype 类型
        // 获取输出流
        PrintWriter printWriter = resp.getWriter();
        String username = req.getParameter("username");

        // 通过 cookie 给传递过去
        Cookie cookie = new Cookie("username", username);
        resp.addCookie(cookie);
        /**
         * 设置 cookie 的最大持久时间
         * seconds < 0 会话 cookie
         * seconds = 0 删除 cookie
         * seconds > 0 设置最大时间 单位为秒
         */
        cookie.setMaxAge(15);


        printWriter.print("欢迎" + username + "</br>");
        //  http://localhost:8080/param/cookieshowlist  // 通常用这种
        printWriter.print("<a href='cookieshowlist'>收件箱</a>");
        // 如果站点前面加 / 就是跳转最后一个域名     http://localhost:8080/cookieshowlist
        printWriter.print("<a href='/cookieshowlist'>收件箱</a>");


    }

    public void cookieValueEncoding() throws UnsupportedEncodingException {

        // 编码
        String msg = "西门吹雪";
        String encoding = URLEncoder.encode(msg, "UTF-8");

        // 解码
        String string = URLDecoder.decode(encoding, "UTF-8");

    }


    /**
     * cookie 通过响应头传送给客户端，客户端（浏览器）拿到cookie数据后寸到浏览器缓存内部，再次请求时把cookie放到请求头中。
     *
     * cookie 细节
     * cookie 中的内容不能是中文
     * 如果使用中文，可以通过UTF8编码
     *
     * 修改 cookie
     * 1. 创建一个 cookie name 同名的 cookie  相当于覆盖之前的 cookie （因为 cookie 的底层就是 key value）
     * 2. 获取 cookie 对象，通过 setvalue 方法 重新设置新值
     *
     * cookie 的分类
     * 1. 会话 cookie 关闭浏览器之后，cookie 就销毁了
     * 2. 持久化 cookie 可以保留相应的时间段  比如，保持3天不用登陆
     * 默认情况下就是 会话 cookie
     * 设置持久化化 cookie
     *
     * cookie 的路径
     * servlet1("/param/cookielogin")   servlet2("/param/cookieshowlist")
     * 此时 servlet1 是不会把 cookie 发送给 servlet2 的
     * 可以用 cookie 对象.setDomian(二级域名) 来解决这类问题
     */


}
