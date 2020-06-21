package com.zww.lambda.util;

import java.util.List;
import java.util.function.Consumer;

/**
 * @title ParallelUtil
 * @description:
 * @author: zhaoww
 * @create: 2019/05/23
 */
public class ParallelUtil {

    /**
     * ForkJoin方式异步
     * @param datas
     * @param consumer
     * @param <T>
     */
    public <T> void parallelRun(List<T> datas, Consumer<T> consumer){
        datas.parallelStream().forEach(consumer);
    }
}
