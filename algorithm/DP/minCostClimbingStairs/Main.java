package minCostClimbingStairs;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/6 11:10
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int ans = minCostClimbingStairs(cost);
        System.out.println(ans);
    }

    private static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-1], dp[i-1] + cost[i]);
        }
        return dp[cost.length-1];
    }
}
