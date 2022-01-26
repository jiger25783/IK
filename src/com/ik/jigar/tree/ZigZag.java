package com.ik.jigar.tree;

import java.util.*;

public class ZigZag {

    //User function Template for Java

class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}

    class GFG
    {
        //Function to store the zig zag order traversal of tree in a list.
        ArrayList<Integer> zigZagTraversal(Node root)
        {
            //Add your code here.
            if(root == null){
                return new ArrayList<>();
            }
            Queue<Node> q = new LinkedList<>();
            ArrayList<Integer> solList = new ArrayList<>();
            q.add(root);
            boolean flip = false;
            while (!q.isEmpty()){
                List<Integer> currLevelSol = new ArrayList<>();
                int count = q.size(); // one level at a time
                for (int i = 0; i < count; i++) {
                    Node cur = q.remove();
                    currLevelSol.add(cur.data);

                    // now add left and right to the queue if exists
                    if (cur.left != null) q.add(cur.left);
                    if (cur.right != null) q.add(cur.right);
                }
                if (flip){
                    Collections.reverse(currLevelSol);
                }
                // revert the flip flag
                flip = !flip;
                //Add to final solution
                solList.addAll(currLevelSol);
            }
            return solList;
        }
    }
}
