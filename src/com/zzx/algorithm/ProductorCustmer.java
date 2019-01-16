package com.zzx.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ProductorCustmer {
    private final static List<String> eleArr = new ArrayList<String>();
    private final static int maxSize = 10;

    public static void main(String[] args){
        Thread productorThreads = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =10;
                do{
                    synchronized( eleArr ){
                        try {
                            while(eleArr.size() == maxSize){
                                eleArr.wait();
                            }
                            eleArr.add("elem");
                            System.out.println("productor create a elements; now has " + eleArr.size());
                            Thread.sleep(500);
                            eleArr.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }while (i-- !=0);

            }
        });
        Thread custmerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=10;
                do {
                    synchronized (eleArr) {
                        try {
                            while (eleArr.size() == 0) {
                                eleArr.wait();
                            }
                            System.out.println("custmer reduce a elements; now has " + eleArr.size());
                            eleArr.remove(0);
                            Thread.sleep(500);
                            eleArr.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }while (i-- !=0);
            }
        });

        productorThreads.start();
        custmerThread.start();
    }
}
