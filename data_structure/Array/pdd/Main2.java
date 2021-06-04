package pdd;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/26 9:19
 * @Version: 1.0
 */
public class Main2 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ais = new int[n];
        for (int i = 0; i < n; i++) {
            ais[i] = scanner.nextInt();
        }

        int ans = harmonious(ais, m);
        System.out.println(ans);
    }

    private static int harmonious(int[] ais, int m) {
//        dfs(ais, 0, m, 0);
        if (ais.length == 1){
            if (ais[0] % m == 0){
                return 1;
            }else {
                return 0;
            }
        }
        int[][] dp = new int[ais.length][ais.length];
        dp[0][0] = ais[0];
        for (int i = 1; i < ais.length; i++) {
            int sum  = 0;
            dp[i][0] = ais[i];
            if (dp[i][0] % m == 0){
                count++;
            }
            for (int j = i; j < ais.length; j++) {
                sum += ais[j];
                dp[i][j] = dp[i][j-1] + ais[j];
                if (dp[i][j] % m == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[] ais, int i, int m, int sum) {
        for (int j = i; j < ais.length; j++) {
            sum += ais[j];
            if (sum % m == 0){
                count++;
            }
            dfs(ais, j+1, m, sum);
            sum -= ais[j];
        }
    }
}
