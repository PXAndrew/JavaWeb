package web.servlet;

import JDBC.student.dao.IStudentDao;
import JDBC.student.dao.StudentDaoImpl;
import JDBC.student.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/list")
public class ListStudentServlet extends HttpServlet {


    private IStudentDao studentDao;
    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = students = studentDao.list();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/views/student/student_list.jsp").forward(req, resp);

    }
}
