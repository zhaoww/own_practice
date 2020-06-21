package com.zww.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title MyExecutors
 * @description: 测试多线程
 * @author: zhaoww
 * @create: 2019/03/18
 */
public class MyExecutors {

    public static void handle() {
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService executorService = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        System.out.println("start");
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                        System.out.println("===");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        latch.countDown();
                    }
            );
        }
        try {
            latch.await();
            executorService.shutdown();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 共享变量 只能处理可见性
    private static volatile Integer j = 0;

    // 非原子操作
    private static Integer incrData() {
        return ++j;
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static Integer incrAtomData() {
        return atomicInteger.getAndIncrement();
    }

    public static void cas() {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        System.out.println("start");

        for (int i = 0; i < 40; i++) {
            executorService.submit(() -> {
                        System.out.println("===" + incrData() + "===");
                        System.out.println("###" + incrAtomData() + "###");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        executorService.shutdown();
        System.out.println("end");
    }

    // 测试阻塞
    public static void get() {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        System.out.println("start");

        Future<Integer> future = executorService.submit(() -> {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 1;
                }

        );
        Future<Integer> future2 = executorService.submit(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 2;
                }

        );
        try {
            System.out.println(future.get(7000, TimeUnit.MILLISECONDS));
            System.out.println(1111);
            System.out.println(future2.get(7000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("end");

    }

    public static void main(String[] args) {
//        handle();
//        cas();
//        get();
    }
}
