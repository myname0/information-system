package com.nc.ec.informationsystem.controller;

import com.nc.ec.informationsystem.entity.Student;
import com.nc.ec.informationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/all";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStudentById(long id) {
        studentRepository.deleteById(id);
        return "redirect:/all";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public List<Student> getAllStudents(){
//        List <Student> students = studentRepository.findAll();
//        return students;
//    }
    public String list(ModelMap model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student/all";
    }
}
