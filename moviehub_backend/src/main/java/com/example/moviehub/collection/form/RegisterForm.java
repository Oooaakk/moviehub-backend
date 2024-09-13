package com.example.moviehub.collection.form;

public class RegisterForm {

    private String email;
    private String password;
    private String verificationCode;

    private Integer age;
    private String gender;
    private String username;


    public RegisterForm(String email, String password, String verificationCode, Integer age, String gender, String username) {
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.age = age;
        this.gender = gender;
        this.username = username;
    }

    public RegisterForm() {
    }

    public RegisterForm(String email) {
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
