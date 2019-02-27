package com.hou.learn.concurrent;

import java.util.concurrent.*;

/**
 * @outhor ikan
 * @create 2019-02-27 17:49
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool(5);
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread()+"孙子开始运行了");
                Thread.sleep(5000);
                return null;
            }
        });
        executorService.execute(futureTask);

        System.out.println("老子在等结果");
        System.out.println(futureTask.get());
    }
}