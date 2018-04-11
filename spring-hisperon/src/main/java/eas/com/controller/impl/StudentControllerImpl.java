package eas.com.controller.impl;

import eas.com.config.Views;
import eas.com.controller.StudentController;
import eas.com.model.Student;
import eas.com.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentControllerImpl implements StudentController {

    @Resource
    private StudentService studentService;

    @Override
    public String insertAction(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("interests", Arrays.asList(
                "Musica", "Lectura", "Viajes", "Estudio", "Bailar",
                "Salir de Paseo", "Pescar", "Comer", "Turismo", "Camping"
        ));

        return Views.INSERT_STUDENT.url;
    }

    @Override
    public String insertAction(Model model, Student student) {
        this.studentService.insert(student);
        return "redirect:/student";
    }

    @Override
    public String listAction(Model model) {
        model.addAttribute("students", this.studentService.getStudentList());
        return Views.LIST_STUDENT.url;
    }

    @Override
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(this.studentService.getStudentList());
    }
}
