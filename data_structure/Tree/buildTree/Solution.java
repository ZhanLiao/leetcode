package buildTree;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 12:04
 * @Version: 1.0
 */
public class Solution {

    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right){
        if(pre_left > pre_right){
            return null;
        }

        int pre_root = pre_left;
        int in_root = indexMap.get(preorder[pre_root]);

        int numOfLeftTree = in_root - in_left;

        TreeNode root = new TreeNode(preorder[pre_left]);

        root.left = myBuildTree(preorder, inorder, pre_left + 1, pre_left + numOfLeftTree, in_left, in_root - 1);
        root.right = myBuildTree(preorder, inorder, pre_left + numOfLeftTree + 1, pre_right, in_root + 1, in_right);

        return root;
    }
}
