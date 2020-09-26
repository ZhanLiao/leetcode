package levelSearchTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();            
            List<Integer> temp = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

            }
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }
            
}