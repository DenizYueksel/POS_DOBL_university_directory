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


    public Student getStudentByID(Long id){

        return studentRepo.findById(id).get();
    }

    public Student createStudent(String name, String subjectArea, String email, String birthDate ){

        Student student = new Student();

        student.setName(name);
        student.setSubjectArea(subjectArea);
        student.setBirthDate(birthDate);
        student.setEmail(email);

        return studentRepo.save(student);

    }


    public Student editStudent(Long id, String name, String subjectArea, String email, String birthDate ){

        Student student = getStudentByID(id);

        student.setName(name);
        student.setSubjectArea(subjectArea);
        student.setBirthDate(birthDate);
        student.setEmail(email);

        return studentRepo.save(student);

    }

    public void deleteStudentByID(Long id){

        Student student = getStudentByID(id);

        studentRepo.delete(student);


    }


}
