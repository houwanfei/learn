package com.hou.learn.concurrent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 模拟隐藏迭代器抛ConcurrentModificationException
 *
 * @outhor ikan
 * @create 2019-02-26 17:33
 */
public class HiddenIterator {
    private Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i){
        set.add(i);
    }

    public synchronized void remove(Integer i){
        set.remove(i);
    }

    public void tenAdd(){
        Random r = new Random();
        for (int i=0; i<10; i++){
            add(r.nextInt());
        }
        System.out.println("hashset :" + set);
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        HiddenIterator hiddenIterator = new HiddenIterator();
        for (int i=0; i<40; i++){
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread() + "运行");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                hiddenIterator.tenAdd();
            }).start();
        }


    }
}