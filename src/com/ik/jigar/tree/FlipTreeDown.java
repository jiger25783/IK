package com.ik.jigar.tree;

public class FlipTreeDown {

    static TreeNode flipUpsideDown(TreeNode root){
        flipUpsideDown(new TreeNode(), root);

        return root;
    }
    static TreeNode root = null;

    static TreeNode flipUpsideDown(TreeNode current, TreeNode newCurrent){
        //base condition
        if(current == null){
            return null;
        }
        if(current.left_ptr == null && current.right_ptr == null){
            if(root == null){
                root = new TreeNode();
                root.val = current.val;
                newCurrent = root;
            } else {
                TreeNode temp = new TreeNode();
                temp.val = current.val;
                newCurrent.left_ptr = temp;
            }
            return newCurrent;
        }
        if(current.left_ptr != null){
            System.out.println("going left current.val = " + current.val);
            newCurrent = flipUpsideDown(current.left_ptr, newCurrent);
        }
        if(current.right_ptr != null){
            System.out.println("going right current.val = " + current.val);
            newCurrent = flipUpsideDown(current.right_ptr, newCurrent);
        }
        System.out.println("center current.val = " + current.val);
        TreeNode temp = new TreeNode();
        temp.val = current.val;
        newCurrent.right_ptr = temp;
        newCurrent = newCurrent.right_ptr;
        return newCurrent;
    }
}
