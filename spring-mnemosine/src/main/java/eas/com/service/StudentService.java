package eas.com.service;

import eas.com.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    @PostConstruct
    private void init(){
        this.studentList.add(new Student("Luis Daniel", "Ferrer Sanchez", 'M', Arrays.asList("Musica", "Video Juegos", "Lectura", "Excursion")));
        this.studentList.add(new Student("Linet", "Gonzales", 'F', Arrays.asList("Actividades Sociales", "Lectura")));

    }

    public void insert(Student student) {
        this.studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
