package com.ik.jigar.recursion;

import java.util.Arrays;

public class TargetSumInSubArray {
    public static void main(String[] args) {
        long targetSum = -100;
        long[] arr = new long[]{
                500,
                -600,
                7000
        };
        System.out.println("Check if target sum:" + targetSum + " arr:" + Arrays.toString(arr) + " sol:" + check_if_sum_possible(arr, targetSum)) ;
    }
    static boolean check_if_sum_possible(long[] arr, long k) {
        return checkSumPossibleRecursive(arr, k, 0, 0L, 0);

    }

    static boolean checkSumPossibleRecursive(long[] arr, long targetSum, int i, long currentSum, int hasElement){
        //Check if current sum is same as target sum and atleast one element is accounted for
        if(targetSum == currentSum && hasElement > 0){
            return  true;
        }
        //Terminal condition
        if(i >= arr.length){
            //System.out.println(", targetSum = " + targetSum + ", i = " + i + ", currentSum = " + currentSum);
            return currentSum == targetSum && (hasElement > 0);
        }

        //include current element
        if(checkSumPossibleRecursive(arr, targetSum, i+1, currentSum + arr[i], hasElement + 1)) {
            return true;
        }

        //exclude current element
        return checkSumPossibleRecursive(arr, targetSum, i+1, currentSum, hasElement);
    }

}
