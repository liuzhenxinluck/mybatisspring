package com.bh.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
    private List<OrderDetail> orderDetails;
    private   User user;
    private  Integer id;
    private  Integer user_id;
    private String number;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderDetails=" + orderDetails +
                ", user=" + user +
                ", id=" + id +
                ", user_id=" + user_id +
                ", number='" + number + '\'' +
                '}';
    }
}
