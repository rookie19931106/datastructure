package test.treeTest;

import tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num:nums){
            binarySearchTree.add(num);
        }
        binarySearchTree.preOrder();
        binarySearchTree.levelOrder();
    }

}
