package com.ik.jigar.sortassignment;

import com.ik.jigar.sortassignment.resource.SinglyLinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLinkedLists {




    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
        if (lists.size() <= 1){
            return lists.size() == 1 ? lists.get(0) : null;
        }
        SinglyLinkedListNode resultFirst = null;
        SinglyLinkedListNode resultLast = null;
        //System.out.println("lists.size() = " + lists.size());
        do{
            //System.out.println("inside loop lists.size() = " + lists.size());
            int lowIndex = 0;
            SinglyLinkedListNode previousNode = null;
            for (int i = 0; i < lists.size(); i++) {
                SinglyLinkedListNode currentNode = lists.get(i);
                //System.out.println("i:" + i + "currentNode = " + currentNode.data);
                if(currentNode != null && (previousNode == null || currentNode.data < previousNode.data) ){
                    lowIndex = i;
                    previousNode = currentNode;
                }
            }
            //System.out.println("Low:" + lowIndex);
            if(resultFirst == null){
                //System.out.println("First");
                resultFirst = lists.get(lowIndex);
                resultLast = resultFirst;
            } else if (lists.get(lowIndex) != null){
                // System.out.println("non first");
                resultLast.next = lists.get(lowIndex);
                resultLast = resultLast.next;
            }
            if(lists.get(lowIndex) != null && lists.get(lowIndex).next != null) {
                //System.out.println("setting next for index:" + lowIndex + " val:" + lists.get(lowIndex).next.data);
                lists.set(lowIndex, lists.get(lowIndex).next);
            } else {
                //System.out.println("Removing index:" + lowIndex);
                lists.remove(lowIndex);
            }

        }while (lists.size() > 0);

        return resultFirst;
    }


    public static SinglyLinkedListNode merge_k_lists_recursive(List<SinglyLinkedListNode> lists) {
        int yetTobeMerged = lists.size() - 1;
        while (yetTobeMerged > 0){
            int left = 0, right = yetTobeMerged;
            while (left < right){
                //merge left and right list to left position
                System.out.println("list(left) = " + lists.get(left).data);
                System.out.println("list(right) = " + lists.get(right).data);
                lists.set(left,  mergeTwoSortedList(lists.get(left), lists.get(right)));
                System.out.print("For left:"+ left + ":");
                printLinkedList(lists.get(left));
                //increment left and decrement right pointer
                left++;
                right--;

                //set yettobemerge to right ponter if pass is complete
                if(left >= right){
                    yetTobeMerged = right;
                }
            }
        }
        return  lists.get(0);
    }

    public static void printLinkedList(SinglyLinkedListNode root){
        SinglyLinkedListNode currnt = root;
        while(currnt != null){
            System.out.print(currnt.data + "->");
            currnt = currnt.next;
        }
        System.out.println("end");
    }
    public  static SinglyLinkedListNode mergeTwoSortedList(SinglyLinkedListNode l1, SinglyLinkedListNode l2){
        
        if(l1 == null){
            return l2;
        } else if (l2 == null){
            return  l1;                    
        }
        
        SinglyLinkedListNode result = null;
        if(l1.data <= l2.data){
            result = l1;
            result.next = mergeTwoSortedList(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoSortedList(l1, l2.next);
        }
        
        return result;
    }


}
