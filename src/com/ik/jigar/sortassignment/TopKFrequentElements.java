package com.ik.jigar.sortassignment;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(find_top_k_frequent_elements(Arrays.asList(1,1,3,2,4,6,3,3,4,1,1,5), 2));
    }
    static ArrayList<Integer> find_top_k_frequent_elements(List<Integer> arr, Integer k) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> valCountMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            if(valCountMap.get(arr.get(i)) == null){
                valCountMap.put(arr.get(i), 0);
            }
            valCountMap.put(arr.get(i), valCountMap.get(arr.get(i)) + 1);
            //System.out.println("valCountMap = " + valCountMap);
        }
        //MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (Integer a,Integer b)-> {
            int counta = valCountMap.get(a);
            int countb = valCountMap.get(b);
            return countb - counta;
        });

        for (Integer key : valCountMap.keySet()) {
            //System.out.println("key = " + key);
            pq.add(key);
            //System.out.println("pq.toString() = " + pq.toString());
        }

        for (int i = 0; i < k; i++) {
            res.add(pq.poll());

        }
        return res;
    }

}

/*
Top K Frequent Elements

Given an integer array and a number k, find the k most frequent elements in the array.

Example One

Input: [1, 2, 3, 2, 4, 3, 1], 2

Output: [3, 1]

Example Two

Input: [1, 2, 1, 2, 3, 1], 1

Output: [1]

Notes

If multiple answers exist, return any.

The order of numbers in the output array does not matter.

Constraints:

1 <= Array Length <= 3*105.
1 <= k <= Unique elements in the input array.
0 <= Any element in the input array <= 3*105.
Custom Input

Input Format:

The first line contains the size of the input array.

Then the numbers of the array are listed, one in each line.

The last line contains a number denoting k.

Input from “Example One” above would be:

7

1

2

3

2

4

3

1

2

Output Format:

The output should contain k lines where each line will have a single integer.

Output from “Example One” above would be:

3

1
*/