package com.nc.ec.informationsystem.controller;

import com.nc.ec.informationsystem.entity.Student;
import com.nc.ec.informationsystem.repository.GroupRepository;
import com.nc.ec.informationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        model.addAttribute("groups", groupRepository.findAll());
        return "student/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@Valid Student student) {
        studentRepository.save(student);
        return "redirect:/student/" + student.getId();
    }

    @RequestMapping(value = "{id}/delete/", method = RequestMethod.GET)
    public String deleteStudentById(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "redirect:/all";
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
    public String updateStudent(@PathVariable long id, @Valid Student student) {
        studentRepository.save(student);
        return "redirect:/student" + id;
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public String updateStudent(@PathVariable long id, ModelMap model) {
        Student student = studentRepository.findById(id).get();
        model.addAttribute("student", student);
        model.addAttribute("groups", groupRepository.findAll());
        return "student/add";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student/all";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudentById(@PathVariable long id, ModelMap model) {
        Student student = studentRepository.findById(id).get();
        model.addAttribute("student", student);
        return "student/view";
    }
}
