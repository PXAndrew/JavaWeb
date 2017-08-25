package web.servlet;


import JDBC.student.dao.IStudentDao;
import JDBC.student.dao.StudentDaoImpl;
import JDBC.student.model.Student;
import sun.management.Agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/save")
public class SaveStudentServlet extends HttpServlet {

    private IStudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));

        System.out.println(id);

        if (id == null || id.equals("")) {
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            studentDao.save(student);
        } else {
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            student.setId(Long.valueOf(id));
            studentDao.update(student);
        }

        resp.sendRedirect(req.getContextPath() + "/student/list");

    }
}
