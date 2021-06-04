package roteMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/3 15:27
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        rote(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void rote(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int star = i;
            int end = matrix.length-1-i;
            for (int j = 0; j < end - star; j++) {
                int t1 = matrix[star][star+j];
                int t2 = matrix[star+j][end];
                int t3 = matrix[end][end-j];
                int t4 = matrix[end-j][star];
                matrix[star][star+j] = t4;
                matrix[star+j][end] = t1;
                matrix[end][end-j] = t2;
                matrix[end-j][star] = t3;
            }
        }

    }
}
