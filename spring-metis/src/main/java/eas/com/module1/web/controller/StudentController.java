package eas.com.module1.web.controller;

import eas.com.common.entity.Student;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("student")
@RestController
public class StudentController {

    @GetMapping
    public Student getStudent(HttpServletRequest httpServletRequest) {
        Student student = new Student();
        student.setCountry(SecurityContextHolder.getContext().getAuthentication().toString() + " " + httpServletRequest.getSession().getId());
        return student;
    }
}
