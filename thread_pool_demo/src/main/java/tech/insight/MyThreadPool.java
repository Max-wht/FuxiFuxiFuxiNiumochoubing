package tech.insight;

import tech.insight.ExecutorHandlerPolicy.AbortPolicy;
import tech.insight.ExecutorHandlerPolicy.ExecutorHandlerPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Max
 * @description
 * @date 2025/6/24 15:23
 */
public class MyThreadPool implements ThreadPool{
    private final int corePoolSize;
    private final int maxPoolSize;
    private final int queueCapacity;
    private final int waitTime;
    private final TimeUnit timeUnit;
    private final ExecutorHandlerPolicy policy;
    private List<Thread> coreThreads;
    private List<Thread> workThreads;
    private BlockingQueue<Runnable> taskQueue;

    public MyThreadPool(int corePoolSize, int maxPoolSize, int queueCapacity, int waitTime, TimeUnit timeUnit, ExecutorHandlerPolicy policy) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.queueCapacity = queueCapacity;
        this.waitTime = waitTime;
        this.timeUnit = timeUnit;
        this.policy = policy;
        this.taskQueue = new LinkedBlockingQueue<>(queueCapacity);
        this.workThreads = new CopyOnWriteArrayList<>();
        this.coreThreads = new CopyOnWriteArrayList<>();
    }
    public MyThreadPool(int corePoolSize, int maxPoolSize, int queueCapacity, int waitTime, TimeUnit timeUnit) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.queueCapacity = queueCapacity;
        this.waitTime = waitTime;
        this.timeUnit = timeUnit;
        this.policy = new AbortPolicy();
        this.taskQueue = new LinkedBlockingQueue<>(queueCapacity);
        this.workThreads = new CopyOnWriteArrayList<>();
        this.coreThreads = new CopyOnWriteArrayList<>();
    }

    @Override
    public void execute(Runnable task) {
        if (task == null) {
            return;
        }
        synchronized (this) {
            if (coreThreads.size() < corePoolSize) {
                Thread thread = new CoreThread();
                coreThreads.add(thread);
                thread.start();
            }
            boolean offer = taskQueue.offer(task);
            if (offer) {
                return;
            }
            if (coreThreads.size() + workThreads.size() < maxPoolSize ) {
                Thread thread = new WorkerThread();
                workThreads.add(thread);
                thread.start();
            }
        }
        if (!taskQueue.offer(task))
            policy.handle();
    }

    class CoreThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable task = null;
                try {
                    task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore the interrupt status
                    break; // Exit the loop when interrupted
                }
            }
        }
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.poll(waitTime, timeUnit);
                    if (task == null)
                        break;
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            System.out.println("WorkerThread" + Thread.currentThread().getName() + " is stopped");
        }
    }
}
