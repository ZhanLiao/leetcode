package minFallingPathSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/18 14:31
 * @Version: 1.0
 */
public class Main {
    static int[][] memo;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int ans = minFallingPathSum(matrix);
        System.out.println(ans);
    }

    private static int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        memo = new int[matrix.length][matrix.length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(res, dp(matrix, matrix.length-1, i));
        }
        return res;
    }

    private static int dp(int[][] matrix, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix.length){
            return Integer.MAX_VALUE;
        }
        // base case
        if (i == 0){
            return matrix[0][j];
        }
        if (memo[i][j] != Integer.MAX_VALUE){
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + Math.min(dp(matrix, i-1, j-1), Math.min(dp(matrix, i-1, j), dp(matrix, i-1, j+1)));
        return memo[i][j];
    }


    private static int minFallingPathSum2(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m+2];
        int res = Integer.MAX_VALUE;
        // base
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = matrix[0][j-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = matrix[i][j-1] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
            }
        }
        for (int j = 1; j <= m; j++) {
            res = Math.min(res, dp[n-1][j]);
        }
        return res;
    }
}
