package com.ik.jigar.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;

public class Lazy extends  Object{
    private static boolean initialized = false;

    static{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("inside");
//                initialized = true;
                System.out.println("inside done");
            }
        });
        t.start();
        try{
            t.join();
        }catch (InterruptedException e){
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("here");
        System.out.println(initialized);

        BlockingQueue a = new LinkedBlockingQueue();
    }
}

