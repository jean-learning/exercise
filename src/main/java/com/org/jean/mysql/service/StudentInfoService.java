package com.org.jean.mysql.service;

import com.org.jean.dao.StudentInfoDao;
import com.org.jean.mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {
    @Autowired
    StudentInfoDao studentInfoDao;
    public List<Student> getStudentById(String id){

        return studentInfoDao.getStudentById(id);
    }

    public Student updateStudent(Student student){

        return student;
    }

    public void insertStudent(Student student){

        studentInfoDao.insertStudent(student);
    }

    public void deleteStudent(Student student){
        studentInfoDao.deleteStudent(student);
    }
}
