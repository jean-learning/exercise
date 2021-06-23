package com.org.jean.mysql.service;

import com.org.jean.mysql.model.Student;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {

        Student student = new Student();
        student.setAge(resultSet.getInt("age"));
        student.setId(resultSet.getString("id"));
        student.setName(resultSet.getString("name"));
        return student;
    }
}


//public class RunningInfoMapper implements RowMapper<RunningInformation> {
//
//    @Override
//    public RunningInformation mapRow(ResultSet resultSet, int i) throws SQLException {
//
//        RunningInformation runningInformation = new RunningInformation();
//        runningInformation.setRunningId(resultSet.getString("running_id"));
//        runningInformation.setHeartRate(resultSet.getInt("heart_rate"));
//        return runningInformation;
//    }
//}