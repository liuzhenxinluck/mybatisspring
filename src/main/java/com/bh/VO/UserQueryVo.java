package com.bh.VO;

import com.bh.pojo.User;
import com.bh.pojo.UserCustom;

import java.util.List;

public class UserQueryVo  {
    //传入的多个id
    private List<Integer>  ids;
    private  User user;
    //查询条件--包装的所有查询条件
    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    @Override
    public String toString() {
        return "UserQueryVo{" +
                "ids=" + ids +
                ", user=" + user +
                ", userCustom=" + userCustom +
                '}';
    }
}
