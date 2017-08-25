package web.servlet;

import JDBC.student.dao.IStudentDao;
import JDBC.student.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class Student extends HttpServlet{

    private IStudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置类型
        req.setCharacterEncoding("UTF-8");
        // 获取参数
        String cmd = req.getParameter("cmd");

        if (cmd.equals("list")) {
            list(req, resp);
        } else if (cmd.equals("save")) {
            save(req, resp);
        } else if (cmd.equals("delete")) {
            delete(req, resp);
        } else if (cmd.equals("edit")) {
            edit(req, resp);
        }

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JDBC.student.model.Student> students = students = studentDao.list();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/views/student/student_list.jsp").forward(req, resp);
//      找到 path 路径 req.getContextPath()

    }

    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));

        System.out.println(id);

        if (id == null || id.equals("")) {
            JDBC.student.model.Student student = new JDBC.student.model.Student();
            student.setName(name);
            student.setAge(age);
            studentDao.save(student);
        } else {
            JDBC.student.model.Student student = new JDBC.student.model.Student();
            student.setName(name);
            student.setAge(age);
            student.setId(Long.valueOf(id));
            studentDao.update(student);
        }

        resp.sendRedirect(req.getContextPath() + "/student?cmd=list");


    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        studentDao.delete(Long.parseLong(id));
        resp.sendRedirect(req.getContextPath() + "/student?cmd=list");

    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            JDBC.student.model.Student student = studentDao.get(Long.parseLong(id));
            req.setAttribute("student", student);
        }
        req.getRequestDispatcher("/WEB-INF/views/student/student_edit.jsp").forward(req, resp);

    }
}
