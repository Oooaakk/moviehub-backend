package com.example.moviehub.service;

import com.example.moviehub.collection.form.RegisterForm;

public interface RegisterService {


    void sendEmailVerificationCode(String email);


    boolean register(RegisterForm registerForm);
}


