package com.ik.jigar.tree;

public class UniValueSubTree {
    static int findSingleValueTrees(TreeNode root){

        //Base condition null or leaf node
        if(root == null){
            return 0;
        }
        if(root.left_ptr == null && root.right_ptr == null){
            return 1;
        }

        int[] arr = new int[] {0};
        findSingleValueTrees(root, arr);
        return arr[0];
    }

    static boolean findSingleValueTrees(TreeNode root, int[] count){

        //Base condition null or leaf node
        if(root == null){
            return true;
        }
        /* covered by following condition
        if(root.left_ptr == null && root.right_ptr == null){
            count[0]++;
            return true;
        }*/

        // must do here not in if condition as we need to count both left and right.  within if it will only count left if left is false.
        boolean isLeftUnivalue = findSingleValueTrees(root.left_ptr, count);
        boolean isRightUniValue = findSingleValueTrees(root.right_ptr, count);

        if((root.left_ptr == null ||  isLeftUnivalue && root.val == root.left_ptr.val)
                && (root.right_ptr == null || isRightUniValue && root.val == root.right_ptr.val)){
            count[0]++;
            return true;
        };
        return false;
    }
}
