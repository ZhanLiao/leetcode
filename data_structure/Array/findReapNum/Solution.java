package findReapNum;

import java.util.HashSet;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 10:27
 * @Version: 1.0
 */
public class Solution {
    public int findRepeatNum(int[] nums){
        int ans = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        if (nums.length > 0){
            for (int num : nums) {
                if (!hashSet.add(num)){
                    ans = num;
                    break;
                }
            }
        }
        return ans;
    }
}
