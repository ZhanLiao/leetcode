package levelSearchTree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 15:34
 * @Version: 1.0
 */
public class Solution2 {
    public List<Integer> levelOrder(TreeNode root){
        if (root == null){
            return new LinkedList<>();
        }
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode r = queue.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                list.add(r.val);
                if (r.left != null){
                    queue.offer(r.left);
                }
                if (r.right != null){
                    queue.offer(r.right);
                }
            }
        }
        return list;
    }
}
