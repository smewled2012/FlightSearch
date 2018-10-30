package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.studentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    StudentRepository studentRepository;


    // create a home page of index with their respective menu

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }

    // show the list of all students

    @RequestMapping("/showstudent")
    public String showStudent(Model model){
        model.addAttribute("students",studentRepository.findAll());

        return "showStudent";

    }
    // create a student with the respective variables
    @GetMapping("/add")
    public String createStudent(Model model){
        model.addAttribute("student",new Student());
        return "studentform";
    }

    // save the student

    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student student){

        studentRepository.save(student);

        return "index";
    }


}
