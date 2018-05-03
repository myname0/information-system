package com.nc.ec.informationsystem.controller;

import com.nc.ec.informationsystem.entity.Group;
import com.nc.ec.informationsystem.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(Group group) {
        groupRepository.save(group);
        return "redirect:/all";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStudentById(long id) {
        groupRepository.deleteById(id);
        return "redirect:/all";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(Group group) {
        groupRepository.save(group);
        return "redirect:/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Group> getAllStudents() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }
}
