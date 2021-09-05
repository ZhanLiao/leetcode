package longestPalindrome;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/8/30 16:27
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ans = deal(s);
//        String ans = longestPalindrome(s);
        System.out.println(ans);
    }

    private static String deal(String s) {
        int len = s.length();
        if (len <= 1){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l++) {
            // 枚举左边界
            for (int i = 0; i < len; i++) {
                // 求左边界
                int j = i + len - 1;
                if (j >= len){
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 记录左边界
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

}
