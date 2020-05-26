package com.example.consult.server.impl;

import com.example.consult.dao.RoleDao;
import com.example.consult.entity.RestResult;
import com.example.consult.entity.ResultCode;
import com.example.consult.entity.Role;
import com.example.consult.server.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public RestResult getRoleById(int roleID) {
        try {
            Role role = roleDao.getRole(roleID);
            return new RestResult(ResultCode.SUCCESS, role);
        }catch (Exception e){
            return new RestResult(ResultCode.ERROR, e.getMessage());
        }
    }
}
