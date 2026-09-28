package com.sahil.crud_springboot.services;

import com.sahil.crud_springboot.entity.Student;
import com.sahil.crud_springboot.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentResponse = studentRepository.save(studentReq);
        return studentResponse;
    }

    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    public List<Student> getStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }


    public Student updateStudent(Long studentId, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setEmail(studentReq.getEmail());

        return studentRepository.save(studentToSave);

    }
}
