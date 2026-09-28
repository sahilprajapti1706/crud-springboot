package com.sahil.crud_springboot.repository;

import com.sahil.crud_springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
