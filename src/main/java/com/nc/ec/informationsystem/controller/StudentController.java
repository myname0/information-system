package com.nc.ec.informationsystem.controller;

import com.nc.ec.informationsystem.controller.form.StudentForm;
import com.nc.ec.informationsystem.entity.Student;
import com.nc.ec.informationsystem.repository.GroupRepository;
import com.nc.ec.informationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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
    @Autowired
    ConversionService conversionService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        model.addAttribute("student", new StudentForm());
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("link", "/student/add");
        return "/student/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@Valid StudentForm studentForm) {
        Student student = conversionService.convert(studentForm, Student.class);
        studentRepository.save(student.getName(), student.getGroupId(), student.getDate());
        return "redirect:/student/all";
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public String deleteStudentById(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "redirect:/student/all";
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
    public String updateStudent(@PathVariable long id, @Valid StudentForm studentForm) {
        Student student = conversionService.convert(studentForm, Student.class);
        studentRepository.update(id, student.getName(), student.getGroupId(), student.getDate());
        return "redirect:/student/" + id;
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public String updateStudent(@PathVariable long id, ModelMap model) {
        Student student = studentRepository.findById(id);
        StudentForm studentForm = conversionService.convert(student, StudentForm.class);
        model.addAttribute("student", studentForm);
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("link", "/student/" + id + "/edit");
        return "/student/add";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("students", studentRepository.findAll());
        return "/student/all";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudentById(@PathVariable long id, ModelMap model) {
        Student student = studentRepository.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("group", groupRepository.findById(student.getGroupId()));
        return "/student/view";
    }
}
