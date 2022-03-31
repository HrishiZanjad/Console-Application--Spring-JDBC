package com.spring.jdbc.Dao;

import com.spring.jdbc.Entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(int StudentId);
    public Student getStudent(int StudentId);
    public List<Student> getAllStudent();
}
