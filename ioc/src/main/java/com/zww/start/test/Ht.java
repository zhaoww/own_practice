package com.zww.start.test;

import com.zww.start.vo.Person;

/**
 * @title Ht
 * @description:
 * @author: zhaoww
 * @create: 2019/05/20
 */
public class Ht {
    public static void main(String[] args){
        Person p = Person.builder()
                .age(1)
                .name("aa")
                .build();

    }
}
