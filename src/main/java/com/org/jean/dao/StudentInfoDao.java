package com.org.jean.dao;

import com.org.jean.mysql.config.QueryConfig;
import com.org.jean.mysql.model.QueryProperties;
import com.org.jean.mysql.model.Student;
import com.org.jean.mysql.service.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component
public class StudentInfoDao {
    @Autowired
    @Qualifier("mySql")
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    QueryConfig queryConfig;
    @Autowired
    QueryProperties queryProperties;
    public void insertStudent(Student student){
        String query = "insert into students values('"+ student.getId()+"','"+student.getName()+"',"+student.getAge()+")";
        jdbcTemplate.execute(query);

    }

    public void deleteStudent(Student student){
        String query = "delete from students where id = '"+ student.getId()+"'";
        jdbcTemplate.execute(query);

    }
//    public Student getStudents(){
//        return jdbcTemplate.query("select id, name, age from students where id = ", new StudentMapper());
//    }
    public List<Student> getStudentById(String id){
//        String s = queryConfig.getQuerybyid();
        String s = queryProperties.getKey();
        return jdbcTemplate.query(s+ id, new StudentMapper());
    }

//    public Student updateStudent(Student student){
//
//    }
}
