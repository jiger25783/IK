package com.ik.jigar.tree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {


    /*
        private static class TreeNode{
            public int val;
            public TreeNode left_ptr;
            public TreeNode right_ptr;
        }

        Complete the function below.
    */

    static TreeNode merge_two_BSTs(TreeNode root1, TreeNode root2){
        List<Integer> list1 =  new ArrayList<Integer>(); inorder(root1,list1);
        List<Integer> list2 = new ArrayList<Integer>(); inorder(root2, list2);
        List<Integer> res = mergeTowLists(list1, list2);
        return buildBalancedTreeFromSortedArray(res, 0, res.size() -1);

    }

    static TreeNode buildBalancedTreeFromSortedArray(List<Integer> list, int low, int high){
        if(low >= high){
            if(low > high){
                return null;
            }
            TreeNode node = new TreeNode();
            node.val = list.get(high);
            return node;
        }

        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode();
        node.val = list.get(mid);
        node.left_ptr = buildBalancedTreeFromSortedArray(list, low, mid-1);
        node.right_ptr = buildBalancedTreeFromSortedArray(list, mid+1, high);
        return  node;
    }

    static void inorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        if(node.left_ptr != null){
            inorder(node.left_ptr, list);
        }
        list.add(node.val);
        if(node.right_ptr != null){
            inorder(node.right_ptr, list);
        }
    }

    static List<Integer> mergeTowLists(List<Integer> l1, List<Integer> l2){
        if(l1 == null || l1.size() < 1){
            return l2;
        }
        if(l2 == null || l2.size() < 1){
            return l1;
        }

        List<Integer> res = new ArrayList<>();

        int l1i=0, l2i=0;
        while(l1i < l1.size() && l2i < l2.size()){
            if(l1.get(l1i) <= l2.get(l2i)){
                res.add(l1.get(l1i));
                l1i++;
            } else{
                res.add(l2.get(l2i));
                l2i++;
            }
        }

        while(l1i < l1.size() && l2i < l2.size()){
            if(l1.get(l1i) <= l2.get(l2i)){
                res.add(l1.get(l1i));
                l1i++;
            } else{
                res.add(l2.get(l2i));
                l2i++;
            }
        }

        while(l1i < l1.size()){
            res.add(l1.get(l1i));
            l1i++;
        }


        while(l2i < l2.size()){
            res.add(l2.get(l2i));
            l2i++;
        }
        return res;
    }
}