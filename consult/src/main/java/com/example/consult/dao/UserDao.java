package com.example.consult.dao;

import com.example.consult.entity.User;
import org.apache.ibatis.annotations.*;
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


    //删除用户
    @Delete("delete from user where id = #{id}")
    public void deleteUser(int id);


    //修改用户信息
    @Update({"<script>"
            + "update user set"
            + "<if test='password!=null'>password = #{password},</if>"
            + "<if test='name!=null'>name = #{name},</if>"
            + "<if test='phone!=null'>phone = #{phone},</if>"
            + "<if test='block!=null'>block = #{block},</if>"
            + "<if test='address!=null'>address = #{address},</if>"
            + "<if test='email!=null'>email = #{email},</if>"
            + "<if test='img!=null'>img = #{img},</if>"
            + "roleID = #{roleID} where id = #{id}"
            + "</script>"})
    public void updateUser(User user);




}
