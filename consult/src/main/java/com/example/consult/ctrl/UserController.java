package com.example.consult.ctrl;

import com.example.consult.entity.RestResult;
import com.example.consult.entity.User;
import com.example.consult.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("regist")
    public RestResult regist(User user){
        return userService.regist(user);
    }

    @RequestMapping("login")
    public RestResult login(User user, HttpServletRequest request){
        return userService.login(user, request);
    }

    @RequestMapping("emailCheak")
    public RestResult emailCheak(String email){
        return userService.emailCheak(email);
    }
}
