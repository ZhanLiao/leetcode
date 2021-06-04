package canJump;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/3 17:34
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        boolean ans = canJump(nums);
    }

    private static boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach){
                return false;
            }
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }

}
