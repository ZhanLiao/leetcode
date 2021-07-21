package isCompleteTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/20 9:20
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        boolean ans = isCompleteTree(root);
        System.out.println(ans);
    }

    private static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        boolean emptyNode = false;
        int size = treeNodes.size();
        while (size > 0){
            TreeNode cur = treeNodes.poll();
            if (cur != null && emptyNode){
                return false;
            }
            if (cur == null){
                emptyNode = true;
            }
            if (cur != null){
                treeNodes.add(cur.left);
                treeNodes.add(cur.right);
            }
            size = treeNodes.size();
        }
        /*while (!treeNodes.isEmpty()){
            int size = treeNodes.size();
            TreeNode cur = treeNodes.poll();
            for (int i = 0; i < size; i++) {
                if (emptyNode && cur != null){
                    return false;
                }
                if (cur == null){
                    emptyNode = true;
                }
                if (cur != null){
                    treeNodes.add(cur.right);
                    treeNodes.add(cur.left);
                }
            }
        }*/
        return true;
    }
}
    // Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(int val) { this.val = val; }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
