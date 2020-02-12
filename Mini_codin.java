package test;

import java.util.*;

/**
 * @Author:wrb
 * @Date :2020/2/11/17:37
 * @Describtion:
 **/
public class Mini_codin {
        private String digits;
        private List<String> result;
        private StringBuilder stringBuilder;
        private static Map<Integer,String> map = new HashMap<>();
        public List<String> letterCombinations(String digits) {
            mapDataInit(map);
            this.digits = digits;
            result = new ArrayList<>();
            if(digits.length() == 0) {
                return result;
            }
            stringBuilder = new StringBuilder();
            combination(0);
            return result;
        }

        private static void mapDataInit(Map<Integer,String> map){
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

        private void combination(int currentIndex) {
            if(currentIndex == digits.length()) {
                result.add(stringBuilder.toString().toLowerCase());
                return;
            }
            int index = digits.charAt(currentIndex)-'0';
            if("".equals(map.get(index))){
                currentIndex++;
            }
            for(char c: map.get(index).toCharArray()) {
                stringBuilder.append(c);
                combination(currentIndex + 1);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

    public static void main(String[] args) {
        Mini_codin obj = new Mini_codin();
        String s = "59";
        System.out.println(Arrays.toString(obj.letterCombinations(s).toArray()));;
    }

}
