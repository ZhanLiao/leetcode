package buildTree;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description: 由前序和中序构建二叉树
 * @Date: 2021/6/7 16:58
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] preorder = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            preorder[i] = Integer.valueOf(s[i]);
        }
        String[] s1 = scanner.nextLine().split(" ");
        int[] inorder = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            inorder[i] = Integer.valueOf(s1[i]);
        }
//        System.out.println(Arrays.toString(preorder));
//        System.out.println(Arrays.toString(inorder));
        TreeNode ans = buildTree(preorder, inorder);

    }


    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(indexMap, preorder, inorder, 0, n-1, 0, n-1);

    }

    private static TreeNode myBuildTree(HashMap<Integer, Integer> indexMap, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight){
            return null;
        }
        // 找出前序和中序的root所在索引
        int pre_root = preLeft;
        int in_root = indexMap.get(preorder[pre_root]);
        TreeNode root = new TreeNode(preorder[pre_root]);
        int sizeOfSubTree = in_root - inLeft;
        root.left = myBuildTree(indexMap, preorder, inorder, preLeft+1, preLeft+sizeOfSubTree, inLeft, in_root - 1);
        root.right = myBuildTree(indexMap, preorder, inorder, preLeft+sizeOfSubTree+1, preRight, in_root+1, inRight);
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){

    };

    public TreeNode(int val) {
        this.val = val;
    }
}

