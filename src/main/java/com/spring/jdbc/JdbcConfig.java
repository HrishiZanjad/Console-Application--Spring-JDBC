package com.spring.jdbc;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc")
public class JdbcConfig {
    @Bean("ds")
    public DataSource getDiverManager(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("Pass@9525");
        return dataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDiverManager());
        return jdbcTemplate;
    }

//    @Bean("studentDao")
//    public StudentDao getStudentDao(){
//        StudentDaoImpl studentDao=new StudentDaoImpl();
//        studentDao.setTemplate(getTemplate());
//        return studentDao;
//    }
}
