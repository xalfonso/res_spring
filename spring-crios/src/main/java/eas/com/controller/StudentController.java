package eas.com.controller;

import eas.com.model.Student;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
public interface StudentController {

    @GetMapping("/insert")
    String insertAction(Model model);

    @PostMapping("/insert")
    String insertAction(Model model, Student student);

    @GetMapping
    String listAction(Model model);
}
