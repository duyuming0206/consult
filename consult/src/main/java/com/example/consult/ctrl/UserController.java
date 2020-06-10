package com.example.consult.ctrl;

import com.example.consult.entity.RestResult;
import com.example.consult.entity.User;
import com.example.consult.server.RoleService;
import com.example.consult.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping("api/regist")
    public RestResult regist(User user){
        return userService.regist(user);
    }

    @RequestMapping("api/login")
    public RestResult login(User user, HttpServletRequest request){
        System.out.println(request.getSession().getId());
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

    @RequestMapping("api/updateUser")
    public RestResult updateUser(User user, HttpServletRequest request) {
        return userService.updateUser(user, request);
    }

    @RequestMapping("api/getRole")
    public RestResult getRole(HttpServletRequest request) {
        int roleID=1;
        User user=(User)request.getSession().getAttribute("user");
        if(user!=null)
        {
            roleID=user.getRoleID();
        }
        return roleService.getRoleById(roleID);
    }
    @RequestMapping("api/getUser")
    public RestResult getUser(HttpServletRequest request) {
        return userService.getuser(request);
    }
    @RequestMapping("api/setImg")
    public RestResult getUser(String img,HttpServletRequest request) {
        return userService.setImg(img, request);
    }
}
