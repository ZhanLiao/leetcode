package romanToInt;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description: 把罗马数字翻译为十进制数字
 * @Date: 2021/7/8 2:28
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int ans = romanToInt(s);
        System.out.println(ans);
    }

    private static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);map.put('X', 10);map.put('L', 50);
        map.put('C', 100);map.put('D', 500);map.put('M', 1000);
        HashMap<String, Integer> sMap = new HashMap<>();
        sMap.put("IV", 4);sMap.put("IX", 9);
        sMap.put("XL", 40);sMap.put("XC", 90);
        sMap.put("CD", 400);sMap.put("CM", 900);
        char[] chars = s.toCharArray();
        if (chars.length == 1){
            return map.get(chars[0]);
        }
        int res = map.get(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char a = chars[i-1];
            char b = chars[i];
            String temp = String.valueOf(a) + String.valueOf(b);
            if (!sMap.containsKey(temp)){
                res += map.get(b);
            }else {
                res = res - map.get(a) + sMap.get(temp);
            }
        }
        return res;
    }
}
