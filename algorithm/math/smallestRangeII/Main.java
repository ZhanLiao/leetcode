package smallestRangeII;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/7 21:42
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {1, 3, 6};
        int k = 3;
        int ans = smallestRangeII(nums, k);
        System.out.println(ans);

    }

    private static int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);

        int res = nums[nums.length-1] - nums[0];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i+1];
            min = Math.min(nums[0] + k, b - k);
            max = Math.max(nums[nums.length - 1] - k, a + k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
