package canPartitionKsubset;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/6 10:31
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        /**
         * 优化一下，将传入的数组降序排序，目的更快触发剪枝操作。
         */
        Arrays.sort(nums);
        int j = nums.length;
        for (int i = 0; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        if (canPartitionKSubsets(nums, k)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除不合法的情况:长度小于k,总和不能均分为k
        if (nums.length < k){
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0){
            return false;
        }

        int target = sum / k;   // 每个子集的数据和
        int[] bucket = new int[k];  //  存储每个子集的数据和
        // 深度遍历
        return dfs(nums, 0, target, bucket);
    }

    /**
     * 递归遍历的是数字
     * @param nums
     * @param index
     * @param target
     * @param bucket
     * @return
     */
    private static boolean dfs(int[] nums, int index, int target, int[] bucket) {
        //结束条件
        if (nums.length == index){
            for (int b : bucket) {
                if (b != target){
                    return false;
                }
            }
            return true;
        }
        // 决定要放入那个子集里面
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝
            if (bucket[i] + nums[index] > target){
                continue;
            }
            // 做选择决策
            bucket[i] += nums[index];
            // 下一层
            if (dfs(nums, index+1, target, bucket)){
                return true;
            }
            // 取消选择
            bucket[i] -= nums[index];
        }
        return false;
    }
}
