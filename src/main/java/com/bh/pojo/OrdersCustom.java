package com.bh.pojo;
//继承了orders类和自定义扩展
public class OrdersCustom extends Orders {
    private String username;
    private  String address;

    // 自定义用户扩展类
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "OrdersCustom{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", orders=" +super.toString() +
                '}';
    }
}
