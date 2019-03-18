package com.zww.start.config;

import com.zww.start.vo.MyFactoryBean;
import com.zww.start.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title IocConfig
 * @description: config
 * @author: zhaoww
 * @create: 2019/03/19
 */
@Configuration
public class IocConfig {
    /**
     * 用代码配置方式注入一个bean
     */
    @Bean(name = "person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(100);
        person.setName("张三");
        return person;
    }

    @Bean(name = "myFactoryBean")
    public MyFactoryBean getMyFactoryBean(){
        MyFactoryBean myFactoryBean = new MyFactoryBean();
        myFactoryBean.setType("it");
        return myFactoryBean;
    }
}
