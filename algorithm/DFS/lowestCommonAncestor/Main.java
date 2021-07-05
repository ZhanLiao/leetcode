package lowestCommonAncestor;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/2 16:22
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 针对二叉搜索树可以解决
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // 两个节点在右侧
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // 两个节点在左侧
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // 两个节点在异侧
        return root;
    }

    // 针对二叉树的
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.val == q.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null){
            return null;
        }
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root; //q.p在两边
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){ }

    TreeNode(int val){
        this.val = val;
    }
}