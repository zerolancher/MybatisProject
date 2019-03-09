package com.itheima.zero.mapper;

import com.itheima.zero.pojo.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> queryRoleWithUser() throws  Exception;
}
