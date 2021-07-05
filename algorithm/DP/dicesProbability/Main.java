package dicesProbability;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/29 11:45
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] ans = dicesProbability(n);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 采用DP
     * @param n
     * @return
     */
    private static double[] dicesProbability2(int n){
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }

    private static double[] dicesProbability(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(0, n, map, 0);
        double[] res = new double[map.size()];
        int i = 0;
        int sumCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sumCount += entry.getValue();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i++] = entry.getValue()/(double)sumCount;
        }
        return res;
    }

    private static void dfs(int i, int n, HashMap<Integer, Integer> map, int count) {
        if (i == n){
            map.put(count, map.getOrDefault(count, 0)+1);
            return;
        }

        for (int j = 1; j <= 6; j++) {
            count += j;
            dfs(i+1, n, map, count);
            count -= j;
        }
    }
}
