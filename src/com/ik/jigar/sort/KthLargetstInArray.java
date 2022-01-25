package com.ik.jigar.sort;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargetstInArray {


    // Complete the function below.
    public static int kth_largest_in_an_array(List<Integer> numbers, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b)->{
            return  a-b;
        });
        for (int i = 0; i < numbers.size(); i++) {
            minHeap.add(numbers.get(i));
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return  minHeap.peek();
    }
}
