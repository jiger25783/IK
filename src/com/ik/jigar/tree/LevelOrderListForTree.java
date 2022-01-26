package com.ik.jigar.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderListForTree {

    public List<List<Integer>> getLevelOrderList(Node<Integer> node){
        if(node == null) {
            return null;
        }
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(node);
        List<List<Integer>> ret = new ArrayList<>();

        while ( !q.isEmpty()){
            int count = q.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Node<Integer> element = q.remove();
                currList.add(element.getVal());

                if(element.left != null) q.add(element.left);
                if(element.righ != null) q.add(element.righ);

                /*
                // In case of n ary tree
                for (Node child: element.childrens) {
                    q.add(child);
                }
                */
            }
        }

        return ret;

    }
}


class  Node<T> {
    T val;
    Node left;
    Node righ;
    List<Node> childrens;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRigh() {
        return righ;
    }

    public void setRigh(Node righ) {
        this.righ = righ;
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }
}