package web.servlet;

import JDBC.student.dao.IStudentDao;
import JDBC.student.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/delete")
public class RemoveStudentServlet extends HttpServlet {

    private IStudentDao studentDao;

    @Override
    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        studentDao.delete(Long.parseLong(id));
        resp.sendRedirect(req.getContextPath() + "/student/list");
    }
}
