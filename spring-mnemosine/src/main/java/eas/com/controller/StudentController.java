package eas.com.controller;

import eas.com.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/student")
public interface StudentController {

    @GetMapping
    ResponseEntity<List<Student>> getAll();

    @GetMapping("{id}")
    ResponseEntity<String> get(@PathVariable Long id);


    @GetMapping("/AsyncRestTemplate")
    ResponseEntity<String> getResultForExternalService();
}
