package tribonacci;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:第 N 个泰波那契数,T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * @Date: 2021/7/6 10:00
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = tribonacci(n);
    }

    private static int tribonacci(int n) {
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
