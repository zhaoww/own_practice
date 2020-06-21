package com.zww.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @title Parallel
 * @description:
 * @author: zhaoww
 * @create: 2019/05/20
 */
public class Parallel {

    private static void parallelForEach() {
        // Caused by: java.lang.ArrayIndexOutOfBoundsException
        List<String> list = Collections.synchronizedList(new ArrayList<>(10));
        IntStream.range(0, 10000).mapToObj(String::valueOf).parallel().forEach(i -> list.add((i)));

        List<String> list2 = new ArrayList<>(10000);
        IntStream.range(0, 10000).mapToObj(String::valueOf).parallel().forEach(i -> list2.add((i)));
    }

    public static void main(String[] args) {
        parallelForEach();
    }
}
