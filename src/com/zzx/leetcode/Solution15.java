package com.zzx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args){
        Solution15 solution = new Solution15();
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[0];
        int[] nums = new int[]{-1,-1,0,0,0,1,1,1,2,2,2};
        System.out.println(solution.threeSum(nums));
    }

    /**
     * 三个数之和
     * 1、排序
     * 2、遍历0到n-2，在剩的数里选两个数之后等于 当前数的负数
     * 2-1、出现已经比他大的时候可以结束本次循环
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return result;
        }
        List<Integer> list = null;
        int len = nums.length;
        Arrays.sort(nums);
        int iVal,nVal,mVal;
        for(int i=0; i< len-2;i++){
            if(i>0 && nums[i] == nums[i-1]){//去掉第一个重复值
                continue;
            }else if((iVal=nums[i]) >=0) {//最小值必须小于或者等于0
                if(iVal == 0 && nums[i+1]==0 && nums[i+2]==0){
                    list = new ArrayList<Integer>();
                    list.add(0);
                    list.add(0);
                    list.add(0);
                    result.add(list);
                }
                break;
            }
            for(int min=i+1;min < len; min++){
                if((nVal=nums[min]) + iVal> 0){
                    break;
                }else if(min != i+1 && nVal == nums[min-1]){
                    continue;
                }
                mVal = 0 -(nVal+iVal);
                for(int max = min+1; max < len;max++){
                    if((nVal = nums[max]) == mVal){
                        list = new ArrayList<Integer>();
                        list.add(iVal);
                        list.add(nums[min]);
                        list.add(nVal);
                        result.add(list);
                        break;
                    }
                    if(nVal > mVal){
                        break;
                    }else if(max-1 != min && nVal == nums[max-1]){
                        while(max+1 < len && nVal == nums[max+1]){
                            max +=1;
                        }
                        continue;
                    }
                }
            }
        }
        return result;
    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if(nums.length<3){
//            return result;
//        }
//        List<Integer> one = null;
//        int len = nums.length;
//        Arrays.sort(nums);
//        for(int i=0; i< len-2;i++){
//            if(nums[i] > 0) {//最小值必须小于或者等于0
//                break;
//            }else if(nums[i] == 0 && nums[i+1] == 0 && nums[i+2] == 0){
//                one = new ArrayList<Integer>();
//                one.add(0);
//                one.add(0);
//                one.add(0);
//                result.add(one);
//                break;
//            }else if(i>0 && nums[i] == nums[i-1]){
//                continue;
//            }
//            for(int min=i+1,max = i+2;min < len && max < len; max++){
//                if(nums[min] + nums[max] + nums[i] == 0){
//                    one = new ArrayList<Integer>();
//                    one.add(nums[i]);
//                    one.add(nums[min]);
//                    one.add(nums[max]);
//                    result.add(one);
//                }else if(nums[min] + nums[max] + nums[i] > 0 ){
//                    min++;
//                    while(min < len && nums[min-1] == nums[min]){
//                        min++;
//                    }
//                    max=min;
//                    continue;
//                }
//                while(max+1 < len && nums[max] == nums[max+1]){
//                    max++;
//                }
//                if(max == len-1){
//                    min ++;
//                    while(min < len && nums[min-1] == nums[min]){
//                        min++;
//                    }
//                    if(min == max){//i后面的数组已经遍历完
//                        break;
//                    }
//                    max=min;
//                }
//            }
//        }
//        return result;
//    }
}
