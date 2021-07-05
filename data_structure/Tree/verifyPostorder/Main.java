package verifyPostorder;

import tree.TreeNode;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 16:32
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5};
        boolean ans = verifyPostorder(nums);
        System.out.println(ans);
    }

    private static boolean verifyPostorder(int[] nums) {

        return verifyPostorderCur(nums, 0, nums.length-1);
    }

    private static boolean verifyPostorderCur(int[] nums, int i, int j) {
        if (i >= j){
            return true;
        }

        // 才用分治的思想， 先找出第一次大于当前节点的位置
        // 然后要求左子树都小于当前节点，右子树都大于当前节点
        int p = i;
        while (nums[p] < nums[j]){
            p++;
        }
        int segment = p;    // 找到当前子树的左右分割位置
        while (nums[p] > nums[j]){
            p++;
        }
        return p == j && verifyPostorderCur(nums, i, segment-1) && verifyPostorderCur(nums, segment, j-1);
    }
}
