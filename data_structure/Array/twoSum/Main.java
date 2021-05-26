package twoSum;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/26 17:40
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //有多少个元素
        int target = scanner.nextInt();  //目标值
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如何巧妙地解决相同元素，但是索引不一致
            if (indexMap.containsKey(target - nums[i])){
                res[0] = indexMap.get(target - nums[i]);
                res[1] = i;
            }
            indexMap.put(nums[i], i);
        }

        return res;
    }
}
