package com.spring.jdbc.Dao;

import com.spring.jdbc.Entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class rowMapperImpl implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student=new Student();
        student.setId(rs.getInt(1));
        student.setName((rs.getString(2)));
        student.setCity(rs.getString(3));
        return student;
    }
}
