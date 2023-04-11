package com.springboot.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableScheduling
@Component
public class TestThreadPoolExecutor {

    private static final Logger logger = LoggerFactory.getLogger(TestThreadPoolExecutor.class);

    private Long startTime = System.currentTimeMillis();

//    @Scheduled(cron = "${scheduled}")
    public void execute() {
        System.out.println("=====execute start=====");
        try {
            System.out.println("execute startTime:" + startTime);
            this.executeTask();
            System.out.println("execute useTime:" + (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("=====execute end=====");
    }

    private void executeTask() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new NameTreadFactory(), new MyIgnorePolicy());

        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public class MyRunable implements Runnable {
        private String name;
        public MyRunable(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Long startTime = System.currentTimeMillis();
                Thread.sleep(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        @Override
        public String toString() {
            return "MyTask [name=" + name + "]";
        }
    }

    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            logger.info(t.getName() + " has been created");
            return t;
        }
    }

    public static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }
        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            logger.info(r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
        }
    }

}
