package tech.insight.useReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Max
 * @description
 * @date 2025/6/24 20:11
 */
public class Printer implements Runnable{
    private final ReentrantLock lock;
    private final Condition[] conditions;
    private final int id;
    private static final int TOTAL_COUNT = 100;
    private static int currentCount = 1;
    private static int threadId = 1;

    public Printer(ReentrantLock lock, Condition[] conditions, int id) {
        this.lock = lock;
        this.conditions = conditions;
        this.id = id;
    }


    @Override
    public void run() {
        while (currentCount <= TOTAL_COUNT) {
            lock.lock();
            try {
                if (id != threadId)
                    conditions[id - 1].await();
                if (currentCount <= TOTAL_COUNT) {
                    System.out.println("Thread-" + id + " is printing: " + currentCount++);
                    threadId = (threadId % 3)+1;
                    conditions[threadId - 1].signal();
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread-" + id + " is err");
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
