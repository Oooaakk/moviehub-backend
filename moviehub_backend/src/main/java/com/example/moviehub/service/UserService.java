package com.example.moviehub.service;

import com.example.moviehub.collection.form.RegisterForm;
import com.example.moviehub.collection.User;

public interface UserService {
    Boolean registerUser(RegisterForm registerForm);
    String loginUser(User user);

    void deleteUser(User user);

}
