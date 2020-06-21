package com.zww.lambda.test;

import com.zww.lambda.util.ParallelUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @title Test
 * @description:
 * @author: zhaoww
 * @create: 2019/05/23
 */
public class Test {
    public static void main(String[] args){
        ParallelUtil parallelUtil = new ParallelUtil();
        List<Integer> datas = Arrays.asList(1,2,3,4,5);
        parallelUtil.parallelRun(datas, System.out::println);
    }
}
