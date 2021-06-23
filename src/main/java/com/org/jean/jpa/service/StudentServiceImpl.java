package com.org.jean.jpa.service;

import com.org.jean.jpa.StudentService;
import com.org.jean.mysql.model.Student;
import com.org.jean.jpa.controller.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("db")
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public List<Student> findByName(String name, Pageable pageable) {
        List<Student> students = studentRepository.findByName(name);
        return students;
    }
}
