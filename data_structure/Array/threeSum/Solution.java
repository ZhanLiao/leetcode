package threeSum;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/25 17:51
 * @Version: 1.0
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len <= 2){
            return ans;
        }
        //先对数组排序，便于将重复的元素跳过
        Arrays.sort(nums);

        //查找第一个数
        for (int i = 0; i < len - 2; i++) {
            //某个数大于0，则证明后面的数都大于0，不能之和等0；
            if (nums[i] > 0) {
                break;
            }
            //对第一个数去重
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            //查找后面两个之和等于目标值
            int left = i+1;
            int right = len - 1;
            while (left < right){
                if (nums[left] + nums[right] == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if (nums[left] + nums[right] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
