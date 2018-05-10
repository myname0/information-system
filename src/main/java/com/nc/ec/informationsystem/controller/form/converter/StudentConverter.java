package com.nc.ec.informationsystem.controller.form.converter;

import com.nc.ec.informationsystem.controller.form.StudentForm;
import com.nc.ec.informationsystem.entity.Student;
import com.nc.ec.informationsystem.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter implements Converter<StudentForm, Student> {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public Student convert(StudentForm studentForm) {
        Student student = new Student();
        student.setId(studentForm.getId());
        student.setName(studentForm.getName());
        student.setGroupId(studentForm.getGroupId());
        student.setDate(studentForm.getDate());
        return student;
    }
}
