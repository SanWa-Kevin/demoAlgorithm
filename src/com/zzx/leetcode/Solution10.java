package com.zzx.leetcode;

public class Solution10 {
    public static void main(String args[]){
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.romanToInt("IIII"));
        Long lon = System.currentTimeMillis();
        int i = solution10.romanToInt1("IV");
        System.out.println(System.currentTimeMillis()-lon+ " ms");
        System.out.println(i);
    }
    //罗马数据转整数
    public int romanToInt(String s) {
        int before = 0;
        int num = 0;
        for(char c : s.toCharArray()){
            int code = explain(c);
            if(code > before){//只能隔一个
                num += (code - before) -before;
            }else {
                num +=code;
            }
            before = code;
        }
        return num;
    }
    public int romanToInt1(String s) {
        int before = 0;
        int num = 0;
        for(char c : s.toCharArray()){
            int code = explain(c);
            if(code < 0){
                return 0;
            }
            if(code > before && (before*5 == code || before*10 == code) && istrue(before,code)){//只能隔一个
                 num += (code - before) -before;
            }else if(code <= before || before == 0){
                num +=code;
            }
            before = code;
        }
        return num;
    }
    //解释 词义
    public int explain(char c){
        if(c == 'I'){
            return 1;
        }else if(c == 'V'){
            return 5;
        }else if(c == 'X'){
            return 10;
        }else if(c == 'L'){
            return 50;
        }else if(c == 'C'){
            return 100;
        }else if(c == 'D'){
            return 500;
        }else if(c == 'M'){
            return 1000;
        }else{
            return -1;
        }
    }

    public boolean istrue(int before,int num){
        boolean bool = false;
        if(before*5 == num || before*10 == num){
            while(before == 1 || (before = before/10) != 0 ){
                if(before == 1){
                    bool = true;
                    break;
                }
            }
        }
        return bool;
    }
}
