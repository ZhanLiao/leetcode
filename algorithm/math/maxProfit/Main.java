package maxProfit;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/29 19:41
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] prices = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            prices[i] = Integer.valueOf(s[i]);
        }
        int ans = maxProfit(prices);
        System.out.println(ans);
    }

    /**
     * 动态规划求解
     * @param prices
     * @return
     */
    private static int maxProfit1(int[] prices) {
        int[] dp = new int[prices.length+1];
        int buy = Integer.MAX_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            //求出前i天中，最小买入值
            buy = Math.min(buy, prices[i-1]);
            dp[i] = Math.max(dp[i-1], prices[i-1] - buy);
        }
        return dp[prices.length];
    }

    /**
     * 暴力解法，先遍历买入 是在哪一天，再遍历卖出在哪一天
     * @param prices
     * @return
     */
    private static int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length-1; i++) {
            int buy = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                int sell = prices[j];
                if (sell >= buy){
                    res = Math.max(res, sell - buy);
                }
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
