package eas.com.module1.web.controller;

import eas.com.common.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("student")
@RestController
public class StudentController {

    @GetMapping
    public Student getStudent() {
        Student student = new Student();
        student.setCountry("Ecuador");
        return student;
    }
}
