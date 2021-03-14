package com.bh.impl;

import com.bh.pojo.OrderDetail;
import com.bh.pojo.Orders;
import com.bh.pojo.OrdersCustom;
import com.bh.pojo.User;

import java.util.List;

public interface OrdersMapper {
    //查询所有订单 方法名对应映射文件的id名
    public List<OrdersCustom> findOrdersList();

    public List<Orders> findOrdersListResultMap();
    //一对多查询 方法名对应映射文件的id名
    public List<OrderDetail> findOrderDetailList();
    //多对多查询 方法名对应映射文件的id名
    public List<User> findUserOrderListResultMap();
    //一级缓存的测试 方法一
    public User test(Integer id);
    //一级缓存的测试 方法二
    public User updata(User user);


}
