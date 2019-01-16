package com.zzx.leetcode;

public class Solution9 {
    public static void main(String[] args){
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(-2147483648)? "true":"false" );
    }
    //判断整书是否是回文数
    public boolean isPalindrome(int x) {
        int build =0;
        if(x!=0 && x%10<=0)return false;//负数和10的倍数 都不是回文数
        while( x > build){
            int pop = x%10;
            build = build*10 + pop;
            x /= 10;
        }
        if(build == x || build == (x*10 + build%10)){
            return true;
        }
        return false;
    }
}
