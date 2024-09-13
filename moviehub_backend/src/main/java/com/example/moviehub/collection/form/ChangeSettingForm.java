package com.example.moviehub.collection.form;

public class ChangeSettingForm {

    private Integer age;
    private String gender;
    private String username;

    public ChangeSettingForm(Integer age, String gender, String username) {
        this.age = age;
        this.gender = gender;
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
