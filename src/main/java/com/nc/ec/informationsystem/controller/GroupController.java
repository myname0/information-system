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

import javax.validation.Valid;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addGroup(@Valid Groups group) {
        groupRepository.save(group);
        return "redirect:/group/" + group.getId();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGroup(ModelMap model) {
        model.addAttribute("group", new Groups());
        return "group/add";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteGroupById(@PathVariable long id) {
        groupRepository.deleteById(id);
        return "redirect:/group/all";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateGroup(@Valid Groups group) {
        groupRepository.save(group);
        return "redirect:/group/" + group.getId();
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String updateGroup(@PathVariable long id, ModelMap model) {
        Groups group = groupRepository.findById(id).get();
        model.addAttribute("group", group);
        return "group/add";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllGroups(ModelMap model) {
        model.addAttribute("groups", groupRepository.findAll());
        return "group/all";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getGroupById(@PathVariable long id, ModelMap model) {
        Groups groups = groupRepository.findById(id).get();
        model.addAttribute("group", groups);
        return "group/view";
    }
}
