package findUgly;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/19 11:09
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int ans = 1;
        // dp[i]第i个丑数
        int[] dp = new int[n];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(Math.min( 2 * dp[p2], 3 * dp[p3]), 5 * dp[p5]);
            if(dp[i] == 2 * dp[p2]){
                p2++;
            }
            if(dp[i] == 3 * dp[p3]){
                p3++;
            }
            if(dp[i] == 5 * dp[p5]){
                p5++;
            }
        }
        ans = dp[n];
        return ans;
    }
}
