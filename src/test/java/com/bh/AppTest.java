package com.bh;

import static org.junit.Assert.assertTrue;

import com.bh.pojo.Person;
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

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
        //创建会话工厂
    private SqlSessionFactory  sqlSessionFactory;
    @Before
    public void  createSqlsessionFactory() throws IOException {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
            //根据配置文件创建SqlSessionFactory（session会话工厂）
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void  testFindUserById() {
        //数据库连接对象
        SqlSession sqlSession = null;
        try {
            //通过会话工厂创建Sqlsession 数据库对象实例化
            sqlSession = sqlSessionFactory.openSession();
            //查询id=1的用户
            User user = sqlSession.selectOne("UserTest.findUserById",1);
            System.out.println(user);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public  void  testInsert(){
        //数据库连接对象
        SqlSession sqlSession =null;
        try {
            //通过会话工厂创建Sqlsession 数据库对象实例化
            sqlSession =sqlSessionFactory.openSession();
            //添加
            User user = new User();
            user.setUsername("刘小新");
            user.setSex("男");
            user.setAddress("上海");
            sqlSession.insert("UserTest.insertUser",user);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public  void  testDelete(){
        //数据库连接对象
        SqlSession sqlSession =null;
        try {
            //通过会话工厂创建Sqlsession 数据库对象实例化
            sqlSession =sqlSessionFactory.openSession();
               //删除id=35的数据
            sqlSession.delete("UserTest.deleteUserById",35);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
    @Test
    public  void  testUpdata(){
        //数据库连接对象
        SqlSession sqlSession =null;
        try {
            //通过会话工厂创建Sqlsession 数据库对象实例化
            sqlSession =sqlSessionFactory.openSession();
             //修改id=1的数据
            User user =new User();
            user.setId(1);
            user.setUsername("刘小新");
            sqlSession.update("UserTest.updataUser",user);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
    @Test
    public  void  testUUid(){
        //数据库连接对象
        SqlSession sqlSession =null;
        try {
            //通过会话工厂创建Sqlsession 数据库对象实例化
            sqlSession =sqlSessionFactory.openSession();
            //uuid的使用
            Person person = new Person();
            person.setUsername("刘小新");
            person.setSex("男");
            person.setAddress("北京");
            sqlSession.insert("UserTest.insertUUid",person);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public  void  testByName(){
        //数据库连接对象
        SqlSession sqlSession =null;
        try {
            //通过会话工厂创建Sqlsession 数据库对象实例化
            sqlSession =sqlSessionFactory.openSession();
            List<User> list = sqlSession.selectList("UserTest.findUserByName","小");
            System.out.println(list);
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
