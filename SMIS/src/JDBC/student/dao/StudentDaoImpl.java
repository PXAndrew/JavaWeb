package JDBC.student.dao;


import JDBC.student.Template.IResultsetHandler;
import JDBC.student.Template.Template;
import JDBC.student.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {


    @Override
    public void save(Student student) {
        Template.dmlUpdate("INSERT INTO s_student (name, age) VALUES (?, ?)", student.getName(), student.getAge());
    }

    @Override
    public void delete(Long id) {

        Template.dmlUpdate("DELETE FROM s_student WHERE id = ?", id);


    }

    @Override
    public void update(Student student) {

        Template.dmlUpdate("UPDATE s_student SET name = ?, age = ? WHERE id = ?", student.getName(), student.getId(), student.getId());

    }

    @Override
    public Student get(Long id) {

        return Template.dqlQuery("SELECT * FROM s_student WHERE id = ?", new IResultsetHandler<Student>() {
            @Override
            public Student handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAge(resultSet.getInt("age"));
                    return student;
                }
                return null;
            }
        }, id);

    }

    @Override
    public List<Student> list() {

        List<Student> studentList = new ArrayList<>();
        return Template.dqlQuery("SELECT * FROM s_student", new StudentResultsetHandler());

    }

    public Long getCount() {
        return Template.dqlQuery("SELECT COUNT(id) FROM s_student", new IResultsetHandler<Long>() {
            @Override
            public Long handle(ResultSet resultSet) throws SQLException {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
                return 0L;
            }
        });
    }

    class StudentResultsetHandler implements IResultsetHandler<List<Student>> {
        @Override
        public List<Student> handle(ResultSet resultSet) throws SQLException {

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                studentList.add(student);
            }
            return studentList;
        }
    }
}
