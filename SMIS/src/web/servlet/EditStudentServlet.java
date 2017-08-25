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

@WebServlet("/student/edit")
public class EditStudentServlet extends HttpServlet {

    private IStudentDao studentDao;
    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Student student = studentDao.get(Long.parseLong(id));
            req.setAttribute("student", student);
        }
        req.getRequestDispatcher("/WEB-INF/views/student/student_edit.jsp").forward(req, resp);
    }
}
