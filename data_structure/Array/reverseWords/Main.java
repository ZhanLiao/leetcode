package reverseWords;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/2 9:01
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ans = reverseWords2(s);
        System.out.println(ans);
    }

    private static String reverseWords(String s) {
        if (s.length() == 0){
            return "";
        }
        String ss = s.trim();
        char[] chars = ss.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' '){
                temp.append(chars[i]);
                if (i == 0){
                    stringBuilder.append(temp.reverse());
                }
            }else {
                stringBuilder.append(temp.reverse());
                stringBuilder.append(' ');
                temp = new StringBuilder();
                while(chars[i-1] == ' ' && i-1 >= 0){
                    i--;
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 快慢指针
     * @param s
     * @return
     */
    private static String reverseWords2(String s){
        // 需要去除首尾空字符串
        String s1 = s.trim();
        char[] chars = s1.toCharArray();
        int j = chars.length - 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = chars.length - 1; i >= 0;) {
            while (i >= 0 && chars[i] != ' '){
                i--;
            }
            stringBuilder.append(s1.substring(i+1, j+1) +  " ");
            // 中间可能会出现字符串
            while (i >= 0 && chars[i] == ' '){
                i--;
            }
            j = i;
        }
        return stringBuilder.toString().trim();
    }
}
