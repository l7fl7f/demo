package com.springboot.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TPETest {
    volatile int finishState = 0;

    private Lock lock = new ReentrantLock();

    public void test4() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 7, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(threadPoolExecutor);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    String name = "name_" + i;
                    CallableTest testCallable = new CallableTest(name);
                    try {

                        int n1 = threadPoolExecutor.getQueue().size();
                        int n2 = threadPoolExecutor.getPoolSize();
                        int n3 = threadPoolExecutor.getMaximumPoolSize();
                        int n4 = 10;
                        if (n1 + 1 >= n4 + (n3 - n2)) {
                            System.out.println("队列已满，本次不执行");
                            Thread.sleep(200);
                            continue;
                        }

                        executorCompletionService.submit(testCallable);

                        synchronized (lock) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
                            System.out.print(simpleDateFormat.format(new Date()));
                            System.out.print("+++添加任务 name: " + name);
                            System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                            System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                            System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                            System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());
                        }
                    } catch (RejectedExecutionException e) {
                        synchronized (lock) {
                            System.out.println("拒绝：" + name);
                        }
                    } catch (Exception e) {

                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                finishState = 1;
            }
        };

        Thread addThread = new Thread(runnable);
        addThread.start();

        //System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());

        //添加的任务有被抛弃的。taskCount不一定等于添加的任务。
        int completeCount = 0;
        while (!(completeCount == threadPoolExecutor.getTaskCount() && finishState == 1)) {
            Future<String> take = executorCompletionService.take();
            String taskName = take.get();
            synchronized (lock) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
                System.out.print(simpleDateFormat.format(new Date()));
                System.out.print("---完成任务 name: " + taskName);
                System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                System.out.print(" taskCount: " + threadPoolExecutor.getTaskCount());
                System.out.println(" finishTask：" + (++completeCount));

            }
        }

        addThread.join();


        while (threadPoolExecutor.getPoolSize() > 0) {
            Thread.sleep(1000);
            synchronized (lock) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                System.out.print(simpleDateFormat.format(new Date()));
                //System.out.print("name: " + taskName);
                System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());
            }
        }

        // Tell threads to finish off.
        threadPoolExecutor.shutdown();
        // Wait for everything to finish.
        while (!threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("complete");
        }

    }

    public static void main(String[] args) {
        TPETest t = new TPETest();
        try {
            t.test4();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
