package com.org.jean.mysql.controller;

import com.org.jean.mysql.model.Student;
import com.org.jean.mysql.service.StudentInfoService;
//import org.jboss.logging.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/student")
public class MysqlController {
    @Autowired
    StudentInfoService studentInfoService;
//    @GetMapping("/student/getstudentbyid/{id}")
//    public String getStudentById(@PathVariable String id){
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id",id);
//        jsonObject.put("name","abc");
//        jsonObject.put("age",5);
//        return jsonObject.toString();
//    }

    @PostMapping("/updateStudent")
    public Student updateStudentById(@RequestBody Student student){
//        studentInfoService.updateStudent(student);
        return student;
    }

    @PostMapping("/insertStudent")
    public Student insertStudent(@RequestBody Student student){
        studentInfoService.insertStudent(student);
        return student;
    }

    @PostMapping("/deleteStudent")
    public void deleteStudent(@RequestBody Student student){

        studentInfoService.deleteStudent(student);
    }

    @GetMapping("/getstudentbyid")
    public List<Student> getStudentById(@RequestParam String id){
        return studentInfoService.getStudentById(id);
    }
}
