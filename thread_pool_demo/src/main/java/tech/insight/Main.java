package tech.insight;

import tech.insight.ExecutorHandlerPolicy.AbortPolicy;
import tech.insight.ExecutorHandlerPolicy.ExecutorHandlerPolicy;

import java.util.concurrent.TimeUnit;

/**
 * @author Max
 * @description
 * @date 2025/6/24 14:59
 */
public class Main {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(
                5,
                10,
                100,
                1000,
                TimeUnit.MILLISECONDS,
                new AbortPolicy()
        );
        for (int i = 0; i < 100; i++) {
            myThreadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println("主线程over");
    }
}
