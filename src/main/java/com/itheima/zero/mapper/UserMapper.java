package com.itheima.zero.mapper;


import com.itheima.zero.pojo.QueryVo;
import com.itheima.zero.pojo.Role;
import com.itheima.zero.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> queryUserByWhere(User user) throws  Exception;

     List<User> queryUserByForeach(List<Integer> list) throws  Exception;

     List<User> queryUserByArray(int[] user) throws  Exception;

     List<User> queryUserByPojo(QueryVo vo) throws Exception;

     List<User> queryUserByOrdersUID() throws  Exception;

     List<User> QueryUserFromRole() throws Exception;

}
