package com.sahil.crud_springboot.controller;

import com.sahil.crud_springboot.entity.Student;
import com.sahil.crud_springboot.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent) ;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getStudents();
//        if(students.size() ==  0){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(students);
//        }
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId){
        Student student = studentService.getStudentById(studentId);

        if(student == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId,
                                                 @RequestBody Student studentReq){

        Student updatedStudent = studentService.updateStudent(studentId, studentReq);

        if(updatedStudent == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);


    }

}
