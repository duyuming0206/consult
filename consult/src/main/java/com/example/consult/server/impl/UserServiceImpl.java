package com.example.consult.server.impl;

import com.example.consult.dao.UserDao;
import com.example.consult.entity.RestResult;
import com.example.consult.entity.ResultCode;
import com.example.consult.entity.User;
import com.example.consult.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


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
            if (user.getEmail() == null || user.getPassword() == null ||
            user.getName() == null || user.getPhone() == null){
                return new RestResult(ResultCode.FAIL,"入参错误");
            }
            User user1 = userDao.getByEmail(user.getEmail());
            if (user1 != null){
                return new RestResult(ResultCode.FAIL,"入参错误");
            }
            userDao.addUser(user);
            return new RestResult(ResultCode.SUCCESS);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    //登录
    @Override
    public RestResult login(User user, HttpServletRequest request) {
        try {
            User user1 = userDao.getByEmail(user.getEmail());
            if(user1 != null && user1.getPassword().equals(user.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("user", user1);
                return new RestResult(ResultCode.SUCCESS, user1);
            }else {
                return new RestResult(ResultCode.FAIL,"用户名或密码错误");
            }
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    //邮箱验证
    @Override
    public RestResult emailCheak(String email) {
        try {
            User user1 = userDao.getByEmail(email);
            if (user1 != null){
                return new RestResult(ResultCode.FAIL,"该邮箱已经被注册");
            }else {
                return new RestResult(ResultCode.SUCCESS);
            }
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }

    }

    //删除用户
    @Override
    public RestResult deleteUser(int[] list) {
        try {
            for (int i = 1; i < list.length; i++){
                userDao.deleteUser(list[i]);
            }
            return new RestResult(ResultCode.SUCCESS);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }

    //修改用户信息
    @Override
    public RestResult updateUser(User user, HttpServletRequest request) {
        try {
            userDao.updateUser(user);
            User user1 = userDao.getByEmail(user.getEmail());
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.setAttribute("user", user1);
            return new RestResult(ResultCode.SUCCESS, user1);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }


}
