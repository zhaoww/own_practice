package com.zww.start.test;

import com.zww.start.config.IocConfig;
import com.zww.start.vo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @title IocTest
 * @description: 测试
 * @author: zhaoww
 * @create: 2019/03/19
 */
public class IocTest {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);
        Person person = (Person) context.getBean("person");
        Object type = context.getBean("myFactoryBean");
        Object type2 = context.getBean("&myFactoryBean");
        System.out.println(person.getName() + " , " + person.getAge());
    }
}
