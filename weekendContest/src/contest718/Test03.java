package contest718;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/18 11:16
 * @Version: 1.0
 */
public class Test03 {

    public static void main(String[] args) {
//        int[][] points = {{1,2,3}, {1,5,1}, {3,1,1}};
        int[][] points = {{1,5},{2,3},{4,2}};
        int ans = maxPoints(points);
        System.out.println(ans);
    }

    private static int maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        int maxVal = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        // base
        for (int j = 0; j < m; j++) {
            dp[0][j] = points[0][j];
            maxVal = Math.max(maxVal, dp[0][j]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tempMax = 0;
                for (int k = 0; k < m; k++) {
                    tempMax = Math.max(tempMax, dp[i-1][k] + points[i][j] - (Math.abs(k - j)));
                }
                dp[i][j] = tempMax;
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }
        return maxVal;
    }
}
