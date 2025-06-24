package tech.insight.useBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Max
 * @description
 * @date 2025/6/24 21:04
 */
public class Main {
    private static final int TOTAL_COUNT = 100;
    private static final int THREAD_COUNT = 3;

    private static BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<Integer> queue3 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Printer(1, queue1, queue2));
        Thread thread2 = new Thread(new Printer(2, queue2, queue3));
        Thread thread3 = new Thread(new Printer(3, queue3, queue1));

        thread1.start();
        thread2.start();
        thread3.start();

        queue1.put(1);
    }

    static class Printer implements Runnable {
        private int threadId;
        private BlockingQueue<Integer> currentQueue;
        private BlockingQueue<Integer> nextQueue;

        public Printer(int threadId, BlockingQueue<Integer> currentQueue, BlockingQueue<Integer> nextQueue) {
            this.threadId = threadId;
            this.currentQueue = currentQueue;
            this.nextQueue = nextQueue;
        }

        @Override
        public void run() {
            try {
                for (int i = threadId; i <= TOTAL_COUNT; i += THREAD_COUNT) {
                    currentQueue.take();

                    System.out.println(i + "-thread" + threadId);

                    if (i + 1 <= TOTAL_COUNT) {
                        nextQueue.put(i + 1);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}

