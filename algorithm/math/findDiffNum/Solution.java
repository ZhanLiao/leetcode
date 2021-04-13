package findDiffNum;

/**
 * 给定一个数组，其中有一个数只出现一次，其余数字出现两次，找出这个只出现一次的数字
 *
 */
public class Solution {
    /**
     * 采用异或的方法解决，两个相同的数字异或为0。 0和任何数字异或都不变。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
