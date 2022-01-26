package com.ik.jigar.tree;

public class PathSum {

    public boolean pathSumMain(Node<Integer> node, int targetSum) {
        if(node == null){
            return false;
        }
        return pathSum(node, targetSum);
    }
    public boolean pathSum(Node<Integer> node, int targetSum){
        /*
        if(node == null){
            return targetSum == currentSum;
        } */

        if(node.left == null && node.righ == null){
            return  targetSum == node.getVal();
        }
        if(node.left != null) {
            if (pathSum(node.left, targetSum - node.getVal()))
                return true;
        }

        if(node.righ != null)
            pathSum(node.righ, targetSum - node.getVal());

        return false;
    }
}
