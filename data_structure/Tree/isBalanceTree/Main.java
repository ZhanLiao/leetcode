package isBalanceTree;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/18 17:02
 * @Version: 1.0
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean ans = isBanlance(root);
        System.out.println("ans = " + ans);
    }

    private static boolean isBanlance(TreeNode root) {
        return getDeep(root) != -1;
    }

    private static int getDeep(TreeNode root) {
        int res = 0;
        if (root == null){
            return 0;
        }
        int leftDeep = getDeep(root.left);
        if (leftDeep == -1){
            return -1;
        }
        int rightDeep = getDeep(root.right);
        if (rightDeep == -1){
            return -1;
        }
        return Math.abs(rightDeep - leftDeep) < 2 ? Math.max(rightDeep, leftDeep) + 1 : -1;
    }
}
