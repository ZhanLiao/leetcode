package constructArr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/30 16:12
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.valueOf(s[i]);
        }

        int[] ans = constructArr1(a);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 技巧解法
     * @param a
     * @return
     */
    private static int[] constructArr1(int[] a) {
        int[] res = new int[a.length];
        if (a.length == 0){
            return res;
        }
        res[0] = 1;
        int temp = 1;
        //下三角计算
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i-1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--){
            temp *= a[i + 1];
            res[i] *= temp;
        }
        return res;
    }

    /**
     * 暴力解法
     * @param a
     * @return
     */
    private static int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int temp = 1;
            for (int j = 0; j < a.length; j++) {
                if (j == i){
                    continue;
                }else {
                    temp *= a[j];
                }
            }
            res[i] = temp;
        }
        return res;
    }
}
