package isSubStructure;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 11:38
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(4);
        A.left = new TreeNode(3);
        A.right = new TreeNode(2);
        TreeNode B = new TreeNode(5);
        boolean ans = isSubStructure(A, B);
        System.out.println(ans);
    }

    private static boolean isSubStructure(TreeNode a, TreeNode b) {
        boolean res = false;
        if (a != null && b != null){
            if (a.val == b.val){
                res = aIsSubOfB(a, b);
            }
        }
        if (!res){
            res = isSubStructure(a.left, b);
        }
        if (!res){
            res = isSubStructure(a.right, b);
        }
        return res;
    }

    private static boolean aIsSubOfB(TreeNode a, TreeNode b) {
        if (a == null){
            return false;
        }
        if (b == null){
            return true;
        }
        if (a.val != b.val){
            return false;
        }
        return aIsSubOfB(a.left, b.left) && aIsSubOfB(a.right, b.left);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
