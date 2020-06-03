package com.example.consult.ctrl;

import com.example.consult.entity.RestResult;
import com.example.consult.entity.User;
import com.example.consult.server.RoleService;
import com.example.consult.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

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

    @RequestMapping("deleteUser")
    public RestResult deleteUser(int[] list) {
        return userService.deleteUser(list);
    }

    @RequestMapping("updateUser")
    public RestResult updateUser(User user, HttpServletRequest request) {
        return userService.updateUser(user, request);
    }

    @RequestMapping("getRole")
    public RestResult getRole(int roleID) {
        return roleService.getRoleById(roleID);
    }
}
