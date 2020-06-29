package com.lzk.easy;

import java.util.concurrent.CountDownLatch;

/**
 * @author jacquinli
 * @version 1.0
 * @date 2020/6/26 21:45
 */
public class Xiancheng {

    private CountDownLatch s1;
    private CountDownLatch s2;

    public Xiancheng() {
        s1 = new CountDownLatch(1);
        s2 = new CountDownLatch(1);

    }

    public void first(Runnable printFirst) throws InterruptedException {
        s1.countDown();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.countDown();
        s1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        s2.await();
        printThird.run();
    }
}
