package com.org.jean.jpa.controller;

import com.org.jean.jpa.StudentService;
import com.org.jean.mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("db")
@RestController
public class StudentController {
//    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @RequestMapping(value = "/student/name/{name}", method = RequestMethod.GET)
    public List<Student> findByName(@PathVariable String name, @RequestParam(name="page") int page, @RequestParam(name="size") int size){
        return this.studentService.findByName(name, PageRequest.of(page, size));
    }

    @PostMapping("/student/save")
    public void saveStudent(@RequestBody List<Student> student){
        studentService.saveStudents(student);
    }
}
