package findNumberIn2DArray;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/25 22:28
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int target = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        boolean ans = findNumberIn2DArray(matrix, target);
        System.out.println(ans);

    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int t = 0;
        for (int i = m-1; i >= 0; i--) {
            if (matrix[0][i] == target){
                return true;
            }else if (matrix[0][i] < target){
                for (int j = 0; j < n; j++) {
                    if (matrix[j][i] == target){
                        return true;
                    }else if (matrix[j][i] > target){
                        while (matrix[j][i] > target && i < 0){
                            i--;

                        }
                        if (i < 0){
                            return false;
                        }
                        if (matrix[j][i] == target){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
