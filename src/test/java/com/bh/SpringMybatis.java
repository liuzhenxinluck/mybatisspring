package com.bh;

import com.bh.impl.Mapper;
import com.bh.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringMybatis {
    @Test
    public void  testSpringMybatis(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取接口实例 生成代代理对象
        Mapper  mapper = applicationContext.getBean(Mapper.class);
        //调用接口的方法
        User user = mapper.findUserById(1);
        System.out.println(user);
    }
}
