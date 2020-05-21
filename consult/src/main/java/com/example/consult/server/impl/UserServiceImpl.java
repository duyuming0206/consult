package com.example.consult.server.impl;

import com.example.consult.dao.UserDao;
import com.example.consult.entity.RestResult;
import com.example.consult.entity.ResultCode;
import com.example.consult.entity.User;
import com.example.consult.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Service
public class UserServiceImpl implements UserService {

    final
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //注册
    @Override
    public RestResult regist(User user) {
        try {
            User user1 = userDao.getByEmail(user.getEmail());
            if (user1 != null){
                return new RestResult(ResultCode.FAIL,"该邮箱已经被注册");
            }
            userDao.addUser(user);
            
           return new RestResult(ResultCode.SUCCESS);
        }
        catch (Exception e) {
            return new RestResult(ResultCode.ERROR,e.getMessage());
        }
        
    }

    //登录
    @Override
    public RestResult login(User user, HttpServletRequest request) {
        User user1 = userDao.getByEmail(user.getEmail());
        if(user1 != null && user1.getPassword().equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user", user1);
            return new RestResult(ResultCode.SUCCESS, user1);
        }
        return new RestResult(ResultCode.FAIL);
    }

    //邮箱验证
    @Override
    public RestResult emailCheak(String email) {
        User user1 = userDao.getByEmail(email);
        if (user1 != null){
            return new RestResult(ResultCode.FAIL,"该邮箱已经被注册");
        }else {
            return new RestResult(ResultCode.SUCCESS);
        }
    }


}
