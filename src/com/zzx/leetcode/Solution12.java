package com.zzx.leetcode;

public class Solution12 {
    public static void main(String[] args){
        Solution12 solution = new Solution12();
        System.out.println(solution.intToRoman(100));
    }

    //整数转罗马数字
    public String intToRoman(int num) {
        String[] strArr = new String[]{"I","V","X","L","C","D","M"};
        return getRoman(strArr, 0,num,10);
    }
    public String getRoman(String[] strArr, int idx, int n, int base){
        String tmp ="";
        int num = n%10;
        if(num == 0){
            if(n/10 == 0) {
                tmp = strArr[idx+2];
            }
        }else if( num < base/2 -1 ){
            for(int i = 0; i< num; i++){
                tmp += strArr[idx];
            }
        }else if(num == base/2 -1){
            tmp = strArr[idx]+strArr[idx+1];
        }else if(num < base -1){
            tmp = strArr[idx+1];
            for(int i = base/2; i< num; i++){
                tmp += strArr[idx];
            }
        }else if(num == base -1){
            tmp = strArr[idx]+strArr[idx+2];
        }
        if( n/base != 0){
            tmp = getRoman(strArr, idx+2, n/10,10)+tmp;
        }
        return tmp;
    }
}
