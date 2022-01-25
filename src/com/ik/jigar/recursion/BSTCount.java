package com.ik.jigar.recursion;

import java.util.Arrays;

public class BSTCount {

    public static void main(String[] args) {
        System.out.println("BST Count for 4 is:" + how_many_BSTs(4));
    }


    /*
     * Complete the function below.
     */
    static long how_many_BSTs(int n) {
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        return BSTCount(n, count);

    }

    static long BSTCount(int n, int[] count){
        if(n <= 1){
            return count[n];
        }

        /*/ recursive solution
        long bstCount = 0L;
        for(int i = 1; i <= n; i++){
            bstCount += BSTCount(i-1, count) * BSTCount(n-i, count);
        }
        return bstCount;

        */
        //dp solution
        for (int i = 2; i <= n; i++) {
            int left = 0;
            int right = i-1;
            while (left <= i-1){
                count[i] += count[left] * count[right];
                left++;
                right--;
            }
        }
        System.out.println("count = " + Arrays.toString(count));
        return  count[n];

    }

}
