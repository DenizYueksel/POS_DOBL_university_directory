package com.university.directory.controller;

import com.university.directory.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentsController {

    StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model){

        model.addAttribute("students",studentService.allStudents());
        return "students";

    }

    @GetMapping("/students/{id}")
    public  String getStudentByID(Model model, @PathVariable Long id){

        model.addAttribute("student",studentService.getStudentByID(id));
        return "student";

    }

    @PostMapping("/students")
    public String addStudent(@RequestParam(name = "name" )String name, @RequestParam(name = "email") String email, @RequestParam(name = "subjectArea")String subjectArea, @RequestParam(name="birthdate")String birthdate){

        studentService.createStudent(name,subjectArea,email,birthdate);


        return "redirect:/students";
    }

    @PostMapping("/students/{id}")
    public String editStudent(@PathVariable Long id, @RequestParam(name = "name" )String name, @RequestParam(name = "email") String email, @RequestParam(name = "subjectArea")String subjectArea, @RequestParam(name="birthdate")String birthdate){

        studentService.editStudent(id,name,subjectArea,email,birthdate);


        return "redirect:/students";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){

        studentService.deleteStudentByID(id);

        return "redirect:/students";

    }

}
