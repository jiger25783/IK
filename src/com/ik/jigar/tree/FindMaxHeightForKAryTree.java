package com.ik.jigar.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindMaxHeightForKAryTree {


    static TreeNode build_balanced_bst(int[] a)
    {
        TreeNode root = buildTreeBS(a, 0, a.length-1);
        return root;
    }

    static TreeNode buildTreeBS(int[] a, int start, int end){
        Math.log(a.length);
        System.out.println("a = " + Arrays.toString(a) + ", start = " + start + ", end = " + end);
        if(start >= end){
            int index = Math.min(start,end);
            return  new TreeNode(a[index]);
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(a[mid]);
        System.out.println("a[mid] = " + a[mid]);

        root.left_ptr = buildTreeBS(a, start, mid-1);
        root.right_ptr = buildTreeBS(a, mid+1, end);

        return root;
    }

};