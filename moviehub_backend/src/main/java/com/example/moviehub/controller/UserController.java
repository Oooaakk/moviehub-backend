package com.example.moviehub.controller;


import com.example.moviehub.collection.form.ChangePasswordForm;
import com.example.moviehub.collection.form.ChangeSettingForm;
import com.example.moviehub.collection.form.ForgotPasswrodForm;
import com.example.moviehub.collection.JWTSubject;
import com.example.moviehub.collection.form.RegisterForm;
import com.example.moviehub.collection.User;
import com.example.moviehub.service.Impl.RegisterServiceImpl;
import com.example.moviehub.service.Impl.UserServiceImpl;
import com.example.moviehub.util.JWTtokenUtil;
import com.example.moviehub.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private AuthenticationManager authenticationManager;

    private final UserServiceImpl userService;
    private final RegisterServiceImpl registerService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping
    public String save(@RequestBody User user){
        return userService.save(user).getId();
    }

    @PutMapping
    public String update(@RequestBody User user){
        return userService.save(user).getId();
    }

    @PostMapping(value = "/register/email")
    public ResponseEntity<String> verifyEmail(@RequestBody RegisterForm registerForm) {
        System.out.println(registerForm.getEmail());
        try{
            registerService.sendEmailVerificationCode(registerForm.getEmail());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(JsonUtil.toJsonString(e.getMessage()));
        }
        return ResponseEntity.ok().body(JsonUtil.toJsonString("Email Sent"));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody RegisterForm registerForm){


        if (registerService.register(registerForm)){

            return ResponseEntity.ok().body(JsonUtil.toJsonString("Register Succeeded"));
        }else{

            return ResponseEntity.badRequest().body(JsonUtil.toJsonString("Register Failed"));
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user) {
        System.out.println(user);
        String userid = userService.loginUser(user);

        if (userid != null){

            Map<String, String> body = JWTtokenUtil.generateToken(user);
            body.put("id", userid);


            return ResponseEntity.ok(JsonUtil.toJsonString("Login Succeed", body));
        }else{
            return ResponseEntity.badRequest().body(JsonUtil.toJsonString("Login failed"));
        }

    }

    @PostMapping(value = "/forgotPassword")
    public ResponseEntity forgotPassword(@RequestBody ForgotPasswrodForm form){
        System.out.println(form.toString());
        if (userService.forgotPass(form)){
            return ResponseEntity.ok(JsonUtil.toJsonString("Reset Succeed"));
        }else {
            return ResponseEntity.ok(JsonUtil.toJsonString("Reset Failed"));
        }
    }

    @PostMapping(value = "/forgotPassword/email")
    public ResponseEntity resetPassEmail(@RequestBody ForgotPasswrodForm form){
        System.out.println(form.getEmail());
        try{
            userService.sendEmailVerificationCode(form.getEmail());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(JsonUtil.toJsonString(e.getMessage()));
        }

        return ResponseEntity.ok().body(JsonUtil.toJsonString("Email Sent"));
    }


    @PostMapping(value = "/refresh")
    public ResponseEntity refreshToken(HttpServletRequest request, HttpServletResponse response){

//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        String authorizationHeader = request.getHeader("Authorization");
//        System.out.println(authorizationHeader);
        String jwtToken = authorizationHeader.substring(7);

        JWTSubject subject = JWTtokenUtil.decode(jwtToken);

        if (subject.isRefresh()){
            return ResponseEntity.ok().body(JsonUtil.toJsonString("Refresh Token",
                    JWTtokenUtil.generateAccessToken(subject.getEmail())));
        }else{
            return ResponseEntity.badRequest().body(JsonUtil.toJsonString("Invalid Token"));
        }


    }

    @PostMapping(value = "/verify")
    public ResponseEntity verifyToken(){
        return ResponseEntity.ok().body(JsonUtil.toJsonString("Correct credential"));
    }


    @PostMapping(value = "/changePass")
    public ResponseEntity changePass(@RequestBody ChangePasswordForm form){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByEmail(email);
        if (userService.changePass(user, form)){
            return ResponseEntity.ok().body(JsonUtil.toJsonString("Reset Succeeded"));
        }else {
            return ResponseEntity.badRequest().body(JsonUtil.toJsonString("Reset Failed"));
        }
    }

    @PostMapping(value = "/changeSettings")
    public ResponseEntity changeSetting(@RequestBody ChangeSettingForm changeSettingForm){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByEmail(email);
        userService.changeSettings(user, changeSettingForm);

        return ResponseEntity.ok().body(JsonUtil.toJsonString("Reset Succeeded"));
    }

    @GetMapping(value = "/info/userId={id}")
    public ResponseEntity<String> getUserInfo(@PathVariable String id){
        Optional<User> optionalUser = userService.getUserById(id.replaceAll("\\{|\\}", ""));
        return optionalUser
                .map(user -> ResponseEntity.ok().body(JsonUtil.toJsonString("Look Up Success",
                        userService.getUserInfo(user))))
                .orElseGet(() -> ResponseEntity.badRequest().body(JsonUtil.toJsonString("User Not Found")));


    }
}
