package com.bh;

import com.bh.impl.UserMapper;
import com.bh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ResultMapTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public  void createSqlSessionFactory() throws Exception{
        //根据配置文件创建SqlSessionFactory（session会话工厂）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserByIdResultMap(){
        //通过会话工厂创建session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        /*User user = new User();
        user.setId(1);*/
        List<User> list = userMapper.findUserListResultMap(38);
        System.out.println(list);
        sqlSession.close();
    }
}
