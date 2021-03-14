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
import java.util.HashMap;
import java.util.List;

public class HashMapTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void  createSqlsessionFactory() throws Exception{
        //根据配置文件创建SqlSessionFactory（session会话工厂）
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public  void  testFindUserByHashMap(){
        //通过会话工厂创建session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //构造查询条件，即 Map 对象
        HashMap<String,Object> map= new HashMap<>();
        map.put("id",36);
        map.put("username","刘小新");
        List<User> list = userMapper.findUserByHashMap(map);
        System.out.println(list);
        sqlSession.close();
    }
}
