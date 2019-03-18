package com.zww.start.vo;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

/**
 * @title MyFactoryBean
 * @description: 自定义factoryBean
 * @author: zhaoww
 * @create: 2019/03/19
 */
@Data
public class MyFactoryBean implements FactoryBean {
    private String type;
    public Object getObject() {
        return type;
    }

    public Class<?> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
