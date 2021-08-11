package recoverTree;

import tree.TreeNode;

import java.util.ArrayList;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/13 11:29
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        recoverTree(root);
    }

    /**
     * 二叉搜索数中有两个节点位置错了，需要写一个函数恢复位置
     *  1. 中序遍历是升序的
     *  2. 找到错位的两个值交换
     * @param root
     */
    private static void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        // 这种找法可以一次遍历找到位置对调的两个值
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).val > list.get(i+1).val){
                y = list.get(i+1);
                if (x == null){
                    x = list.get(i);
                }
            }
        }
        if (y != null && x != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private static void dfs(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null){
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
