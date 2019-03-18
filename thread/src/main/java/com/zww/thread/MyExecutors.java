package com.zww.thread;

import java.util.concurrent.*;

/**
 * @title MyExecutors
 * @description: 测试多线程
 * @author: zhaoww
 * @create: 2019/03/18
 */
public class MyExecutors {

    public static void handle() {


        for (int i = 0; i < 5; i++) {
            final CountDownLatch latch = new CountDownLatch(1);
            ExecutorService executorService = new ThreadPoolExecutor(4, 4,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());
            System.out.println("start");
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
            System.out.println("end");
            executorService.shutdown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



    public static void main(String[] args) {
        handle();
    }
}
