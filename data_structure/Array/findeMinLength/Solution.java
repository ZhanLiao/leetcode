package findeMinLength;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i= 0, j = 0, n = nums.length-1;
        int flag = Integer.MAX_VALUE;
        if(sum(i, n, nums) < s){
            return 0;
        }
        while(j <= n){
            while(sum(i, j, nums) >= s){
                flag = Math.min(flag, j - i + 1);
                i++;
            }
            j++;
        }
        return flag;

    }

    public int sum (int i, int j, int[] nums){
        int res = 0;
        while(i <= j){
            res += nums[i];
            ++i;
        }
        return res;
    }
}