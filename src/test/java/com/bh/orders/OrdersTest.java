package com.bh.orders;

import com.bh.impl.OrdersMapper;
import com.bh.impl.UserMapper;
import com.bh.pojo.OrderDetail;
import com.bh.pojo.Orders;
import com.bh.pojo.OrdersCustom;
import com.bh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersTest {
    //创建会话工厂
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlsessionFactory() throws IOException {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件创建SqlSessionFactory（session会话工厂）
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //一对一查询
    @Test
    public void testFindOrdersListSql() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> list = ordersMapper.findOrdersList();
        System.out.println(list);
        sqlSession.close();
    }
    //使用resultmap一对一查询
    @Test
    public void testFindOrdersResulsMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> list = ordersMapper.findOrdersListResultMap();
        System.out.println(list);
        sqlSession.close();
    }
    //一对多查询
    @Test
    public void testFindOrdersDetailResulsMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrderDetail> list = ordersMapper.findOrderDetailList();
        System.out.println(list);
        sqlSession.close();
    }
    //多对多查询
    @Test
    public void testFindUserOrdersDetailResulsMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> list = ordersMapper.findUserOrderListResultMap();
        System.out.println(list);
        sqlSession.close();
    }
    //一级缓存区域 测试
    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        User user1 = ordersMapper.test(1);
        User user2 = ordersMapper.test(1);
        System.out.println(user1);
        System.out.println(user2);
        sqlSession.close();
    }

    //一级缓存区域 测试
    @Test
    public void testupdata(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        User user1 = ordersMapper.test(1);
        System.out.println(user1);

        /*User user2 = new User();
        user2.setId(1);
        user2.setUsername("王ba");
        ordersMapper.updata(user2);*/
        sqlSession.commit();
        User user = ordersMapper.test(1);
        System.out.println(user);
        sqlSession.close();
    }

}
