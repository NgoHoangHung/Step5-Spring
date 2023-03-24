package com.example.assgnement1techmaster.model.dto;

import com.example.assgnement1techmaster.model.entity.Clasz;

public class StudentDTO {
    private String nameStudent;
    private Integer age;
    private String level;
    private Clasz clasz;

    public String getNameStudent() {
        return nameStudent;
    }

    public Integer getAge() {
        return age;
    }

    public String getLevel() {
        return level;
    }

    public Clasz getClasz() {
        return clasz;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setClasz(Clasz clasz) {
        Clasz tmp = new Clasz();
        tmp.setId(clasz.getId());
        tmp.setAddress(clasz.getAddress());
        this.clasz = tmp;
    }
}
