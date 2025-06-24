package tech.insight.useReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Max
 * @description
 * @date 2025/6/24 19:46
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 3;
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = new Condition[size];
        for (int i = 0; i < size; i++) {
            conditions[i] = lock.newCondition();
        }
        Thread t1 = new Thread(new Printer(lock, conditions, 1));
        Thread t2 = new Thread(new Printer(lock, conditions, 2));
        Thread t3 = new Thread(new Printer(lock, conditions, 3));

        t1.start();
        t2.start();
        t3.start();
    }
}