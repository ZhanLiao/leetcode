package contest01;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/13 10:40
 * @Version: 1.0
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //有n个三元组
        int[][] triplets = new int[n][3];
        for (int i = 0; i < n; i++) {
            triplets[i][0] = scanner.nextInt();
            triplets[i][1] = scanner.nextInt();
            triplets[i][2] = scanner.nextInt();
        }
        int[] target = new int[3];  //目标值
        for (int i = 0; i < 3; i++) {
            target[i] = scanner.nextInt();
        }

        boolean ans = mergeTriplets(triplets, target);
        if (ans){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    private static boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merge = new int[3];
        int[] visit = new int[triplets.length];
        boolean res = dfs(0, triplets, target, merge, visit);
        return res;
    }

    private static boolean dfs(int k, int[][] triplets, int[] target, int[] merge, int[] visit) {
        if (merge[0] == target[0] && merge[1] == target[1] && merge[2] == target[2]){
            return true;
        }else if (k == triplets.length){
            return false;
        }

        for (int i = 0; i < triplets.length; i++) {
            if (visit[i] == 1){
                continue;
            }
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                temp[j] = merge[j];
                merge[j] = Math.max(merge[j], triplets[i][j]);
            }
            visit[i] = 1;
            if (merge[0] == target[0] && merge[1] == target[1] && merge[2] == target[2]){
                return true;
            }
            if(dfs(k+1, triplets, target, merge, visit)){
                return true;
            }
            visit[i] = 0;
            for (int j = 0; j < 3; j++) {
                merge[j] = temp[j];
            }
        }
        return false;
    }
}
