package com.example.consult.server;


import com.example.consult.entity.RestResult;
import com.example.consult.entity.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    //注册
    public RestResult regist(User user);

    //登录
    public RestResult login(User user, HttpServletRequest request);

    public RestResult emailCheak(String email);

    public RestResult deleteUser(int[] list);

    public RestResult updateUser(User user, HttpServletRequest request);
    public RestResult getuser(HttpServletRequest request);
    public RestResult setImg(String img,HttpServletRequest request);
}
