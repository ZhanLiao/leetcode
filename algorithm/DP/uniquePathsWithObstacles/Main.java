package uniquePathsWithObstacles;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/9/5 10:00
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] obstacleGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                obstacleGrid[i][j] = scanner.nextInt();
            }
        }
        int ans = uniquePathsWithObstacles(obstacleGrid);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
