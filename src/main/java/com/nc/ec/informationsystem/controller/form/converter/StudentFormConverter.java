package com.nc.ec.informationsystem.controller.form.converter;

import com.nc.ec.informationsystem.controller.form.StudentForm;
import com.nc.ec.informationsystem.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentFormConverter implements Converter <Student, StudentForm> {

    @Override
    public StudentForm convert(Student student) {
        StudentForm studentForm = new StudentForm();
        studentForm.setName(student.getName());
        studentForm.setGroupId(student.getGroupId());
        studentForm.setDate(student.getDate());
        return studentForm;
    }
}
