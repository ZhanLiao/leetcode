package coinChange;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/16 9:36
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int ans = coinChange(coins, target);
        System.out.println(ans);
    }

    private static int coinChange(int[] coins, int target) {

        int[] dp = new int[target + 1];
        // base
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = target+1;
        }
        for (int i = 0; i <= target; i++) {
            for (int coin : coins) {
                if (i < coin){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return dp[target] == target+1 ? -1 : dp[target];
    }
}
