package com.ik.jigar.sort;

import java.util.*;

public class KTHLargestInStream {

    public static void main(String[] args) {
        /*
        2
1
1000000000
1
100000000
         */
        System.out.println("Sol is :" + kth_largest(2, Arrays.asList(1000000000), Arrays.asList(100000000)));
    }

    public static List<Integer> kth_largest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, (a, b)->{
            return a-b;
        });

        for (int i = 0; i < initial_stream.size(); i++) {
            minHeap.add(initial_stream.get(i));
        }
        //reduce min heap to size k
        while (minHeap.size() > k){
            minHeap.remove();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < append_stream.size(); i++) {
            System.out.println("minHeap = " + minHeap);
            //add to min heap only append if mean heap size < k or item is bigger then the smallest in heap
            //coz if append is smaller than the smallest in heap i,e, kth largest is not changing
            if(minHeap.peek() < append_stream.get(i) || minHeap.size() < k){
                minHeap.add(append_stream.get(i));
            }
            System.out.println("after add minHeap = " + minHeap);
            // since we are adding one at a time min heap can only grow to k+1
            if(minHeap.size() > k){
                minHeap.remove();
            }
            // now at this point mean heap is always size k which gives us kth largest element
            result.add(minHeap.peek());
            System.out.println("after minHeap = " + minHeap);
        }
        return  result;
    }
}
