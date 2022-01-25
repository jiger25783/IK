package com.ik.jigar.sort;

import java.util.*;

public class OnlineMedian {
    public static void main(String[] args) {
        System.out.println(online_median2(Arrays.asList(3, 8, 5, 2)));
    }


    // Complete the function below.
    public static List<Integer> online_median(List<Integer> stream) {
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < stream.size(); i++) {

            int j = temp.size();
            while (j > 0 && temp.get(j - 1) > stream.get(i)) {
                if (temp.size() <= j) {
                    temp.add(Integer.MAX_VALUE);
                }
                temp.set(j, temp.get(j - 1));
                j--;
            }
            if (temp.size() <= j) {
                temp.add(Integer.MAX_VALUE);
            }
            temp.set(j, stream.get(i));
            int mid = temp.size() / 2;
            System.out.println("temp = " + temp.toString());
            if (temp.size() % 2 == 1) {
                res.add(temp.get(mid));
            } else {
                res.add((temp.get(mid) + temp.get(mid - 1)) / 2);
            }
        }
        return res;
    }

    public static List<Integer> online_median2(List<Integer> stream) {
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Queue<Integer> maxHeap = new PriorityQueue<>(stream.size(), (a, b) -> {
            return b - a;
        });
        for (int i = 0; i < stream.size(); i++) {
            maxHeap.add(stream.get(i));
            int sizeOfCurrentList = i + 1;
            int maxPQSize = (sizeOfCurrentList / 2) + 1;
            while (maxHeap.size() > maxPQSize)
                maxHeap.remove();
            int median = 0;
            System.out.println("maxHeap.toString() = " + maxHeap.toString());
            int mid = maxHeap.remove();
            if (sizeOfCurrentList % 2 == 0) {
                median = mid / 2 + maxHeap.peek() / 2;
            } else {
                median = mid;
            }
            maxHeap.add(mid);
            res.add(median);
        }
        return res;
    }


    /**
     * Keep two heap to store half of the stream.
     * min heap to store right/bigger half of the stream
     * max heap to store left/smaller half of the stream
     * we add each element to min heap (right/bigger half)
     * if size of min heap > size of max heap + 1  then the top of min heap is median
     * if both heap are of same size the median is sum of head of both heap/2
     *
     * @param stream
     * @return
     */
    public static List<Integer> online_median_2heap_Sol(List<Integer> stream) {
     List<Integer> res = new ArrayList<>();

            //min heap to store right/bigger half of the stream
            Queue<Integer> minHeap = new PriorityQueue<>(stream.size(), (a, b) -> {
                return a - b;
            });
            //max heap to store left/smaller half of the stream
            Queue<Integer> maxHeap = new PriorityQueue<>(stream.size(), (a, b) -> {
                return b - a;
            });

            for (int i = 0; i < stream.size(); i++) {
                //we add each element to min heap (right/bigger half)
                minHeap.add(stream.get(i));

                if (minHeap.size() > maxHeap.size()){
                    maxHeap.offer(minHeap.remove());
                    minHeap.offer(maxHeap.remove());
                }
                //if both heap are of same size the median is sum of head of both heap/2
                if (minHeap.size() == maxHeap.size()) {
                    System.out.println(i + " Both same size");
                    System.out.println("minHeap = " + minHeap.toString());
                    System.out.println("maxHeap = " + maxHeap.toString());
                    res.add(minHeap.peek() / 2 + maxHeap.peek() / 2);

                    //if size of min heap = size of max heap + 1  then the top of min heap is median
                } else if (minHeap.size() == maxHeap.size() + 1) {
                    System.out.println(i + " min + 1 ");
                    System.out.println("minHeap = " + minHeap.toString());
                    System.out.println("maxHeap = " + maxHeap.toString());
                    res.add(minHeap.peek());

                    //if size of min heap > size of max heap + 1  then the top of min heap needs to move to max heap
                } /*else {
                System.out.println(i + "min+2");
                System.out.println("minHeap = " + minHeap.toString());
                System.out.println("maxHeap = " + maxHeap.toString());
                maxHeap.add(minHeap.remove());
                res.add(minHeap.peek() / 2 + maxHeap.peek() / 2);
            }*/
            }
            //System.out.println("maxHeap = " + maxHeap.toString());
            return res;
        }
}
