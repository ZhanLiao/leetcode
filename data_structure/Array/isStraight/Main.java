package isStraight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/2 11:16
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        boolean ans = isStraight(nums);
        System.out.println(ans);
    }

    /**
     * 最大值和最小值之和小于5就是顺子
     * @param nums
     * @return
     */
    private static boolean isStraight(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0){
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (hashSet.contains(num)){
                return false;
            }
            hashSet.add(num);
        }
        return max - min < 5;
    }
}
