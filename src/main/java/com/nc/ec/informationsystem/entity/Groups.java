package com.nc.ec.informationsystem.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int number;
    private String faculty;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
