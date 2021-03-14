package com.bh.pojo;

import java.util.Date;
import java.util.List;

public class User {
    //自定义扩展的 集合接受
    private List<OrderDetail> orderDetails;
    private List<Orders> orders;
    private List<Items> items;
    //自身的属性
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" +
                "orderDetails=" + orderDetails +
                ", orders=" + orders +
                ", items=" + items +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
