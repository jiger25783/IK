package com.ik.jigar.sortassignment;

import java.util.Arrays;

public class MergeFirstIntoSecondSorted {
    public static void main(String[] args) {
        int[] a1 = new int[]{13,21};
        int[] res = new int[]{13,13,0,0};
        merger_first_into_second1(a1, res);
        System.out.println("Answer is :" + Arrays.toString(res));
    }

    /*
     * Complete the merger_first_into_second function below.
     * Given two arrays:

1) arr1 of size n, which contains n positive integers sorted in the ascending order.

2) arr2 of size (2*n) (twice the size of first), which contains n positive integers sorted in the ascending order in its first half. Second half of this array arr2 is empty. (Empty elements are marked by 0).

Write a function that takes these two arrays, and merges the first one into second one, resulting in an increasingly sorted array of (2*n) positive integers.
Example
Input:
n = 3
arr1 = [1 3 5]
arr2 = [2 4 6 0 0 0]
Output: arr2 = [1 2 3 4 5 6]
Notes
Input Parameters: There are two arguments. First one is an integer array denoting arr1 and second one is also an integer array denoting arr2.
Output: You don't have to return anything. You just need to modify the given array arr2.
Constraints:
1 <= n <= 10^5
1 <= arr1[i] <= 2 * 10^9
1 <= arr2[i] <= 2 * 10^9 (for the first half)
arr2[i] = 0 (for the second half)
You can use only constant extra space.
0 denotes an empty space.


     */
    static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */

        int[] result = new int[arr2.length];
        int ind1=0, ind2=0;
        int i=0;
        while(ind1 < arr1.length && ind2 < arr1.length){
            System.out.println("result = " + Arrays.toString(result));
            if(arr1[ind1] <= arr2[ind2]){
                result[i] = arr1[ind1++];
            } else {
                System.out.println("i = " + i);
                System.out.println("ind2 = " + ind2);
                result[i] = arr2[ind2++];
            }
            i++;
        }

        while(ind1 < arr1.length ){
            result[i++] = arr1[ind1++];
        }

        while(ind2 < arr1.length){
            result[i++] = arr2[ind2++];
        }

        for(int j=0; j<result.length; j++){
            arr2[j] = result[j];
        }
    }


    static void merger_first_into_second1(int[] arr1, int[] arr2) {
        int i1 = 0, i2 = 0, i=0;
        int [] result = new int[arr2.length];
        while (i1 < arr1.length && i2 < arr1.length){
            if(arr1[i1] <= arr2[i2]){
                result[i] = arr1[i1++];
            } else{
                result[i] = arr2[i2++];
            }
            i++;
        }

        while (i1 < arr1.length){
            result[i] = arr1[i1++];
            i++;
        }

        while (i2 < arr1.length){
            result[i] = arr2[i2++];
            i++;
        }
        for (int j = 0; j < result.length; j++) {
            arr2[j] = result[j];
        }
    }
}
