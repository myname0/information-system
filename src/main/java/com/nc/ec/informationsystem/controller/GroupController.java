package com.nc.ec.informationsystem.controller;

import com.nc.ec.informationsystem.entity.Groups;
import com.nc.ec.informationsystem.repository.GroupRepository;
import com.nc.ec.informationsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGroup(Groups group) {
        groupRepository.save(group);
        return "redirect:/all";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGroupById(long id) {
        groupRepository.deleteById(id);
        return "redirect:/all";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGroup(Groups group) {
        groupRepository.save(group);
        return "redirect:/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Groups> getAllGroups() {
        List<Groups> groups = groupRepository.findAll();
        return groups;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGroupById(@PathVariable long id, ModelMap model){
        return "";
    }
}
