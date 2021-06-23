package com.org.jean.jpa;

import com.org.jean.mysql.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
//    Page<Student> findByName(String name, Pageable pageable);
    List<Student> saveStudents(List<Student> students);
    List<Student> findByName(String name, Pageable pageable);

}
