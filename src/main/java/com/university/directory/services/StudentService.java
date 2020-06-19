package com.university.directory.services;

import com.university.directory.model.Student;
import com.university.directory.repositorys.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    StudentRepo studentRepo;


    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Iterable<Student> allStudents(){

        return studentRepo.findAll();


    }


}
