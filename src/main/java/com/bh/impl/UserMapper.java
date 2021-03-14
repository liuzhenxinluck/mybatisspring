package com.bh.impl;

import com.bh.VO.UserQueryVo;
import com.bh.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    //根据用户id查询用户
    public User findUserById(int id);
    //查询用户列表
    public List<User> findUserByUserName(String username);
    //添加用户信息
    public  void  insertUser(User user);
    //综合查询
    public  List<UserQueryVo> findUserList(UserQueryVo userQueryVo);
    //hashmap的综合查询
    public List<User> findUserByHashMap(HashMap map);
    //简单的类型
    public int findUserByCount(User user);
    //使用resultmap 根据id查询用户信息
    public  List<User> findUserListResultMap(int id);
    //使用sql动态查询
    public List<UserQueryVo> findUserListBy(UserQueryVo userQueryVo);
    //sql片段
    public List<User> findUserListSql(User user);

}