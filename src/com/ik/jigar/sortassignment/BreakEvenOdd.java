package com.ik.jigar.sortassignment;

import java.util.Arrays;

public class BreakEvenOdd {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,9,5,2,9,5,7,10};
        System.out.println("Final Solution:" + Arrays.toString(solve(arr)));

    }
    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {
        if(arr.length <= 1){
            return arr;
        }
        int evenIndex = 0;
        int oddIndex = arr.length - 1;


        while(evenIndex < oddIndex){
            System.out.println("arr = " + Arrays.toString(arr) + "\noddIndex = " + oddIndex + " evenIndex = " + evenIndex);
            if(arr[evenIndex]%2 == 0){ // if even then proceed right
                evenIndex++;
            } else if(arr[oddIndex]%2 != 0){ // if odd proceed left
                oddIndex--;
            } else if(arr[evenIndex]%2 !=0 && arr[oddIndex]%2 == 0){
                // if element at evenIndex is not  even and element at odd index is not odd then swap;
                swap(arr, evenIndex, oddIndex);
                evenIndex++;
                oddIndex--;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
