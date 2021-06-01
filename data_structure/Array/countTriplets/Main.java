package countTriplets;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1、相同的两个数异或为0；
 * 2、任何数与0异或等于其本身；
 * 应用：查找数组中唯一重复的元素
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        System.out.println(Arrays.toString(arr));

        int ans = countTriplets(arr);
        System.out.println(ans);
    }

    private static int countTriplets(int[] arr) {
        int res = 0;
        if (arr.length <= 1){
            return 0;
        }
        // 存取前i项异或的值
        int[] ints = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ints[i+1] = ints[i] ^ arr[i];

        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (ints[i] == ints[k+1]){
//                        System.out.println("i = " + i);
//                        System.out.println("j = " + j);
//                        System.out.println("k = " + k);
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
