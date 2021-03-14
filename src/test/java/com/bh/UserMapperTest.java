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
import java.util.Date;
import java.util.List;

public class UserMapperTest {
    //创建会话工厂
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public  void createSqlsessionFactory() throws Exception{
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //查询id=1的用户
    @Test
    public void testFindUserById(){
        SqlSession sqlSession = null;
        try {
            //获取session
           sqlSession = sqlSessionFactory.openSession();
            //获取mapper接口的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用代理对象方法
            User user = userMapper.findUserById(1);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    //模糊查询 带有李的username
    @Test
    public void testFindUserByUserName(){
        //通过会话工厂创建session
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //获取 mapper 接口实例，mybatis 自动生成 mapper 代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> user = userMapper.findUserByUserName("李");
            System.out.println(user.size());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }

    //添加用户
    @Test
    public void testInsertUser(){

        SqlSession sqlSession = null;
        try {
            sqlSession= sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("小刘");
            user.setSex("男");
            user.setBirthday(new Date());
            user.setAddress("济南");
            userMapper.insertUser(user);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }

    }

}
