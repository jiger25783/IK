package com.ik.jigar.tree;

import java.util.*;

public class IsCompleteBST {
    static boolean isBST(TreeNode root){
        if(root==null || root.left_ptr == null && root.right_ptr == null){
            return  true;
        }
        List<Integer> resList = new ArrayList<>();
        return inorder(root, resList);
    }

    static boolean inorder(TreeNode node, List<Integer> slate){
        if(node.left_ptr == null && node.right_ptr == null){
            slate.add(node.val);
            int size = slate.size();
            if(size == 1){
                return  true;
            }
            System.out.println("slate = " + slate.toString());
            return slate.get(size-1) >= slate.get(size-2);
        }
        if(node.left_ptr != null && inorder(node.left_ptr, slate) == false) return false;

        slate.add(node.val);
        int size = slate.size();
        System.out.println("1 slate = " + slate.toString());
        if(size > 1 && slate.get(size-1) < slate.get(size-2))
            return  false;

        Vector<Integer> v = null;

        return node.right_ptr == null || inorder(node.right_ptr, slate);

    }

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(){
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int val){
            this.val = val;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }
}
