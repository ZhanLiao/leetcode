package maxUncrossedLines;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/23 21:01
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums1 = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums1[i] = Integer.valueOf(s[i]);
        }
        String[] s1 = scanner.nextLine().split(" ");
        int[] nums2 = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums2[i] = Integer.valueOf(s1[i]);
        }
        int ans = maxUncrossedLines(nums1, nums2);
        System.out.println(ans);

    }

    private static int maxUncrossedLines(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        // dp[i][j]表示，包括nums1[i],nums2[j]和其之前在内的值，最大不相交的线个数
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            if (nums1[i] == nums2[0]){
                dp[i][0] = 1;
                for (int j = i+1; j < len1; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int j = 0; j < len2; j++) {
            if (nums2[j] == nums1[0]){
                dp[0][j] = 1;
                for (int i = j+1; i < len2; i++) {
                    dp[0][i] = 1;
                }
                break;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[len1-1][len2-1];
    }
}
