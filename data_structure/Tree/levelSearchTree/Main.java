package levelSearchTree;

import tree.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};
//        int[] arr = {5, 3, 6, 8, 4, 2};


        BST bst = new BST();
        for (int a : arr){
            bst.add(a);
        }
        bst.preOrder();

    }
}
