package longestCommonSubsequence;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/24 11:06
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        scanner.close();
        int ans = longestCommonSubsequence(text1, text2);
        System.out.println(ans);
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        // do
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];

        // 初始状态
        for (int i = 0; i < len1; i++) {
            if (text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
                for (int j = i+1; j < len1; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int j = 0; j < len2; j++) {
            if (text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
                for (int k = j+1; k < len2; k++) {
                    dp[0][k] = 1;
                }
                break;
            }
        }
        //状态转移
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1-1][len2-1];
    }
}
