package com.spring.jdbc.Dao;

import com.spring.jdbc.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate template;

    public int insert(Student student){
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=template.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    public int change(Student student) {
        String query="update student set name=?,city=? where id=?";
        int r=this.template.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    public int delete(int studentId){
        String query="delete from student where id=?";
        int r=template.update(query,studentId);
        return r;
    }

    @Override
    public Student getStudent(int studentId) {
        String query="Select * from student where id=?";
        RowMapper<Student> rowMapper=new rowMapperImpl();
        Student student=this.template.queryForObject(query,rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        //Selecting Multiple Student
        String query="Select * from student";
        List<Student> studentList=this.template.query(query,new rowMapperImpl());
        return studentList;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
