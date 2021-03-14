package com.bh.impl;

import com.bh.pojo.User;

public interface Mapper {
    //根据id进行查找 方法名对应映射文件的id名
    public User findUserById(Integer id);
}
