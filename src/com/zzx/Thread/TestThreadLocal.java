package com.zzx.Thread;

import java.util.Random;

public class TestThreadLocal {
    static ThreadLocal<String> shareVal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return " init_Vale";
        }
    };

    public static void main(String[] args){
        System.out.println("主线程修改前："+Thread.currentThread().getName()+"_"+shareVal.get());
        shareVal.set("main_a");
        System.out.println("子线程启动前："+Thread.currentThread().getName()+"_"+shareVal.get());
        try {
            Thread.sleep(1000);//保证主线程 shareVal 的值修改
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        creatThread().start();
        creatThread().start();
        try {
            Thread.sleep(1000);//保证子线程启动
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程启动后："+Thread.currentThread().getName()+"_"+shareVal.get());
    }
//    //可能因为set 方式
//    static ThreadLocal<String> shareVal = new ThreadLocal<String>();
//    public static void main(String[] args){
//        shareVal.set("main_a");
//        System.out.println("子线程启动前："+Thread.currentThread().getName()+"_"+shareVal.get());
//        try {
//            Thread.sleep(1000);//保证主线程 shareVal 的值修改
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        creatThread().start();
//        creatThread().start();
//        try {
//            Thread.sleep(1000);//保证子线程启动
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("子线程启动后："+Thread.currentThread().getName()+"_"+shareVal.get());
//    }

    public static Thread creatThread(){
       return new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName()+"子线程启动前值为："+shareVal.get());
               int i = new Random().nextInt();
               System.out.println(Thread.currentThread().getName()+"set__"+i);
               shareVal.set(" i= "+i);
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+" get_"+shareVal.get());
           }
       });
    }
}
