package eas.com.controller;

import eas.com.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/student")
public interface StudentController {

    @GetMapping("/insert")
    String insertAction(Model model);

    @PostMapping("/insert")
    String insertAction(Model model, Student student);

    @GetMapping
    String listAction(Model model);

    @CrossOrigin
    @GetMapping("/json")
    ResponseEntity<List<Student>> getAll();
}
