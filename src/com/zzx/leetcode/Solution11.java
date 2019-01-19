package com.zzx.leetcode;

public class Solution11 {
    public static void main(String args[]){
        Solution11 solution = new Solution11();
        int[] intarr = {1,8,6,2,5,4,8,3,7};
        Long lon = System.currentTimeMillis();
        System.out.println(solution.maxArea(intarr));
        System.out.println(System.currentTimeMillis()-lon+ " ms");
    }
    //问题：最大盛水容器

    //两头指针从头开始,值小的下标移动
    public int maxArea(int[] height) {
        int max = -1;
        int i=0, j=height.length-1;
        for(; i < j; ){
            max = Math.max(max, Math.min(height[i],height[j]) * (j-i));
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
    //暴力法
    public int maxArea1(int[] height) {
        int max = -1;
        for(int i =0; i < height.length -1; i++){
            for(int j =i+1; j< height.length; j++){
                int tmp = Math.min(height[i],height[j]) * (j-i);
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        return max;
    }
}
