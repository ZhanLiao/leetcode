package uniquePaths;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description: 不同路径，用动态规划，DFS超时，原因是没有办法剪枝
 * @Date: 2021/6/4 21:54
 * @Version: 1.0
 */
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int ans = uniquePaths(n, m);
        System.out.println(ans);
    }

    private static int uniquePaths(int n, int m) {
        /*int i = 0, j = 0;
        dfs(i, j, n, m);*/
        //dp[i][j] 表示到i,j这个位置有多少条路径
        int[][] dp = new int[n][m];
        //初始值
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    private static void dfs(int i, int j, int n, int m) {
        if (i == n-1 && j == m-1){
            count++;
            return;
        }

        for (int k = 0; k < 2; k++) {
            if (i < 0 || i >= n || j < 0 || j >= m){
                continue;
            }
            dfs(i+1-k, j+k, n, m);
        }
    }
}
