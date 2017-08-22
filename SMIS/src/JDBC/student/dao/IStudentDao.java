package JDBC.student.dao;

import JDBC.student.model.Student;

import java.util.List;

/**
 * 学生对象信息
 * @author Andrew
 */
public interface IStudentDao {

    /**
     * 保存指定的学生对象
     * @param student 要保存的学生对象
     */
    void save(Student student);

    /**
     * 删除学生对象
     * @param id    需要被删除学生的id
     */
    void delete(Long id);

    /**
     * 更新学生数据
     * @param student   新的学生数据
     */
    void update(Student student);

    /**
     * 查询指定 ID 的学生对象
     * @param id    要查询的 ID
     * @return      返回指定的 ID 的 student 对象，找不到返回 null
     */
    Student get(Long id);

    /**
     * 查询所有学生对象
     * @return  如果没有学生对象，则返回空集
     */
    List<Student> list();
}
