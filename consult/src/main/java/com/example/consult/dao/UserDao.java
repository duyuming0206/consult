package com.example.consult.dao;

import com.example.consult.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;



@Mapper
@Component
public interface UserDao {

    //注册
    @Insert("insert into user(email,password,roleID)values(#{email},#{password},#{roleID})")
    public int addUser(User user);


    //根据账号查询 用于登录
    @Select("select * from user where email = #{email}")
    public User getByEmail(String email);




}
