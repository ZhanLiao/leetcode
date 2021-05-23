package kthLargestValueInMatric;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/19 20:51
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] matrix = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                matrix[i][j] = Integer.valueOf(s[j]);
            }
        }
        int ans = kthLargestValue(matrix, k);

        System.out.println(ans);
    }

    private static int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m]; // 存储（i,j）之前值的异或

        // 构建一个小根堆，优先队列默认就是小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i < k; i++) {
            minHeap.add(-1);
        }
        dp[0][0] = matrix[0][0];    // 初始化
        minHeap.add(dp[0][0]);
        // 处理边界值
        for (int i = 1; i < m; i++) {
            dp[0][i] = matrix[0][i] ^ dp[0][i-1];
            if (minHeap.peek() < dp[0][i]){
                minHeap.poll();
                minHeap.add(dp[0][i]);
            }
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0] ^ dp[i-1][0];
            if (minHeap.peek() < dp[i][0]){
                minHeap.poll();
                minHeap.add(dp[i][0]);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = matrix[i][j] ^ dp[i-1][j-1] ^ dp[i-1][j] ^ dp[i][j-1];
                if (minHeap.peek() < dp[i][j]){
                    minHeap.poll();
                    minHeap.add(dp[i][j]);
                }
            }
        }
        return minHeap.peek();
    }
}
