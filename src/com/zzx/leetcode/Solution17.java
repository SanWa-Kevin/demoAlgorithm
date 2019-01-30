package com.zzx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args){
        Solution17 solution = new Solution17();
        String nums = "23";
        System.out.println(solution.letterCombinations(nums));
    }
    //17. 电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()>0){
            String[] str = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            for(int i=0; i< digits.length();i++){
                char num = digits.charAt(i);
                if('1'<num && num <='9'){
                    int idx = Integer.parseInt(""+num);
                    result = getArr(str[idx],result);
                }else{
                    return new ArrayList<String>();
                }
            }
        }
        return result;
    }

    public List<String> getArr(String str ,List<String> list){
        List<String> result = new ArrayList<String>();
        if(list.size() == 0){
            for(int idx=0; idx < str.length();idx++){
                list.add(""+str.charAt(idx));
            }
            return list;
        }else{
            String s = null;
            for(int i =0; i< list.size();i++){
                s = list.get(i);
                for(int idx=0; idx < str.length();idx++){
                    result.add(s + str.charAt(idx));
                }
            }
        }
        return result;
    }
}

