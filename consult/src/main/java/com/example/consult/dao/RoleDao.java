package com.example.consult.dao;

import com.example.consult.entity.Role;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleDao {

    @Select("select * from role where roleID=#{roleID}")
    public List<Role> getRole(int roleID);
}
