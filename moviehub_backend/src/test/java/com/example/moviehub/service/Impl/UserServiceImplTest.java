package com.example.moviehub.service.Impl;

import com.example.moviehub.collection.User;
import com.example.moviehub.collection.form.ChangePasswordForm;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {

    private final String email = "springtest@test.com";
    private final String password = "testpassword";

    @Autowired
    private UserServiceImpl userService;


    //not tested
    @Test
    @Order(1)
    void sendEmailVerificationCode() {
    }

    @Test
    @Order(2)
    void registerUser() {
    }

    @Test
    @Order(3)
    void forgotPass() {
    }

    @Test
    @Order(4)
    void save(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.save(user);
    }

    @Test
    @Order(5)
    void loginUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.loginUser(user);
    }

    @Test
    @Order(6)
    void getUserByEmail() {
        User user = userService.getUserByEmail(email);
        System.out.println(user);
        Assert.notNull(user, "failed to find user");
    }

    @Test
    @Order(7)
    void loadUserByUsername() {
        UserDetails userDetails = userService.loadUserByUsername(email);
        Assert.notNull(userDetails, "failed to find user");
    }

    @Test
    @Order(8)
    void changePass(){
        User temp = userService.getUserByEmail(email);
        ChangePasswordForm form = new ChangePasswordForm(password, "changedpass");
        userService.changePass(temp, form);
        Assert.isTrue(userService.getUserByEmail(email).getPassword().equals("changedpass") );
    }

    @Test
    @Order(9)
    void delete(){
        User user = userService.getUserByEmail(email);
        userService.deleteUser(user);
    }

}