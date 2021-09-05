package longestConsecutive;

import java.util.HashSet;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/8/11 11:03
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int ans = longestConsecutive(nums);
        System.out.println(ans);
    }

    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 不存在前一个值
            if(!set.contains(nums[i] - 1)){
                int curNum = nums[i];
                int curLongest = 1;
                while (set.contains(curNum + 1)){
                    curNum = curNum + 1;
                    curLongest++;
                }
                res = Math.max(res, curLongest);
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
