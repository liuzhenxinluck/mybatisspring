package com.bh;


import com.bh.VO.UserQueryVo;
import com.bh.impl.UserMapper;
import com.bh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QueryTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void  createSqlSessionFactory() throws Exception{
        //根据配置文件创建SqlSessionFactory（session会话工厂）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserList(){
        //创建对象--获取 session
        SqlSession sqlSession=null;
        sqlSession= sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setUsername("刘小新");
        user.setSex("男");

        //传入多个 id
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(34);

        //将 list 通过 userQueryVo 传入 statement 中
        userQueryVo.setIds(list);
        userQueryVo.setUser(user);

        //调用方法完成多条件查询
        List<UserQueryVo> voList = userMapper.findUserList(userQueryVo);
        System.out.println(voList);
        sqlSession.close();

    }

}
