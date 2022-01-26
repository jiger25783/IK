package com.ik.jigar.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathOfBinaryTree {

    static List<List<Integer> > allPathsOfABinaryTree(TreeNode root){
        List<List<Integer>> masterList = new ArrayList<>();
        allPathsOfABinaryTree(root,masterList, new ArrayList<>());
        return masterList;
    }

    static void allPathsOfABinaryTree(TreeNode root, List<List<Integer>> masterList, List<Integer> currList){
        //base condition
        if(root == null){
            return;
        }
        currList.add(root.val);
        if(root.left_ptr == null && root.right_ptr == null){
            masterList.add(getCopyList(currList));
            return;
        }

        if(root.left_ptr != null){
            allPathsOfABinaryTree(root.left_ptr, masterList, currList);
            if(currList.size() >=1){
                currList.remove(currList.size()-1);
            }
        }

        if(root.right_ptr != null){
            allPathsOfABinaryTree(root.right_ptr, masterList, currList);
            if(currList.size() >=1){
                currList.remove(currList.size()-1);
            }
        }
    }

    static List<Integer> getCopyList(List<Integer> source){
        List<Integer> dest = new ArrayList<>();
        for(int i=0; i<source.size(); i++){
            dest.add(source.get(i).intValue());
        }
        return dest;
    }
}
