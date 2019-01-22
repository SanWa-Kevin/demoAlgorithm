package com.zzx.java;

//JVM 测试
public class JVMDemoTest {

    //获取 当前 jvm 内存信息
    public static String getMemoryInfo(){
        Runtime runtime = Runtime.getRuntime();
        int free = (int)(runtime.freeMemory()/1024/1024);// 1MB = 1024KB ，1KB = 1024B （B表示字节Byte，b表示比特bit，位， 1B = 8b，即一个字节等于8位）
        int size = (int)(runtime.totalMemory()/1024/1024);
        return "memory= "+free+"M/"+size+"M(free/size)";
    }

    public static void main(String[] args){
        System.out.println("JVM-Info: "+getMemoryInfo() );
    }
}
