package com.nc.ec.informationsystem.controller.form;

import javax.validation.constraints.NotNull;

public class StudentForm {
    private long id;
    @NotNull
    String name;
    @NotNull
    long groupId;
    @NotNull
    String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
