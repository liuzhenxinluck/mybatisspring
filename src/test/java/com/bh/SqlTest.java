package com.bh;

import com.bh.VO.UserQueryVo;
import com.bh.impl.UserMapper;
import com.bh.pojo.User;
import com.bh.pojo.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SqlTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void createSqlSessionFactory() throws Exception{
        //根据配置文件创建SqlSessionFactory（session会话工厂）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void tsetFindUserList(){
        //通过会话工厂创建session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建 UserMapper 对象，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("周");
        userCustom.setSex("女");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(31);

        userQueryVo.setIds(list);
        userQueryVo.setUserCustom(userCustom);

        List<UserQueryVo> voList  = userMapper.findUserListBy(userQueryVo);
        System.out.println(voList);
        sqlSession.close();

    }

    @Test
    public void testFindUserListSql(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("刘小新");


        List<User> list = userMapper.findUserListSql(user);
        System.out.println(list);
        sqlSession.close();
    }

}
