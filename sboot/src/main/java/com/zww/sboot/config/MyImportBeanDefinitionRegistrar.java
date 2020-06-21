package com.zww.sboot.config;

import com.zww.sboot.bean.TestBean;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义ImportBeanDefinitionRegistrar
 * https://blog.csdn.net/baidu_19473529/article/details/105685333?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-12.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-12.nonecase
 * https://zhuanlan.zhihu.com/p/30123517
 *
 * @author zhaoww
 * @since 2020/06/21
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName(TestBean.class.getName());
        MutablePropertyValues values = beanDefinition.getPropertyValues();
        values.addPropertyValue("id", 1);
        values.addPropertyValue("name", "ZhangSan");
        //这里注册bean
        registry.registerBeanDefinition("testBean", beanDefinition);
    }
}
