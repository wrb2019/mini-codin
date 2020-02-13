package com.wrb;

import java.util.*;

/**
 * @Author:wrb
 * @Date :2020/2/12/21:43
 * @Describtion:
 **/
public class LetterCombination {
    private String digits;
    private List<String> result;
    private StringBuilder stringBuilder;
    private static Map<Integer,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        mapDataInit(map);
        filterData(digits);
        result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        stringBuilder = new StringBuilder();
        combination(0);
        System.out.println("共有："+result.size()+"个组合");
        return result;
    }

    private void combination(int currentIndex) {
        if(currentIndex == digits.length()) {
            result.add(stringBuilder.toString().toLowerCase());
            return;
        }
        int index = digits.charAt(currentIndex)-'0';
        for(char c: map.get(index).toCharArray()) {
            stringBuilder.append(c);
            combination(currentIndex + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
    private void mapDataInit(Map<Integer,String> map){
        map.put(0, "");
        map.put(1, "");
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");
    }

    private void filterData(String str){
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0;i<chars.length;i++){
            int num = chars[i]-'0';
            if (num==0||num==1){
                continue;
            }
            this.digits = sb.append(num).toString();
        }
    }
}
