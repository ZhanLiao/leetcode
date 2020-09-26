package tree;

public class BST {
    private TreeNode root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(int e){
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private TreeNode add(TreeNode node, int e){
        if(node == null){
            size ++;
            return new TreeNode(e);
        }

        if(e < node.val)
            node.left = add(node.left, e);
        else if(e > node.val)
            node.right = add(node.right, e);

        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(int e){
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(TreeNode node, int e){

        if(node == null)
            return false;

        if(e == node.val)
            return true;
        else if(e < node.val)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void  preOrder(TreeNode node){
        if(node == null)
            return;

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
