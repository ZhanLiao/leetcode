package levelSearchTreeTwo;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 16:03
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        List<List<Integer>> lists = levelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (res.size() % 2 == 0){
                    temp.addLast(curNode.val);
                }else {
                    temp.addFirst(curNode.val);
                }
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
