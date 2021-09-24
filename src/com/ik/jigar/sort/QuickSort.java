package com.ik.jigar.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void main(String[] args) {
        /*
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter size of array:");
        int size = s.nextInt();
        int arr[] = new int[size];
        System.out.print("Please enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = s.nextInt();
        } */
        int[] arr = new int[]{6,5,3,2,6,3,1,54,22,11,4};
        quickSortRecursive(arr);
        System.out.println("Sorted array is :");
        Arrays.stream(arr).forEachOrdered(System.out::println);
    }



    private static void quickSortRecursive(int[] arr){
        if(arr.length <= 1)
            return;
        quickSortHelperDevider(arr, 0, arr.length -1);
    }

    private static void quickSortHelperDevider(int[] arr, int start, int end) {
        if(arr.length <= 1)
            return;
        if(start >= end){
            return;
        }
        //Find random pivot position betweem start and end
        int pivotPos = ThreadLocalRandom.current().nextInt(start, end+1);
        //swap pivot to start index thus moving pivot to begining of array
        swapWithinArray(arr, start, pivotPos);
        int smaller = start; // smaller index start at beginning of array where pivot is.
        int bigger = start+1; // bigger index start right after pivot
        while (bigger <= end){ // loop till bigger reach to end
            if(arr[bigger] < arr[start]){ //if element at bigger index is smaller than pivot then swap
                smaller++; // increase smaller to reach beginning of bigger part before swap
                swapWithinArray(arr, bigger,smaller);
            }
            bigger++;
        }
        swapWithinArray(arr, start, smaller); // now smaller is at the location where pivot can be placed so swap pivot to to smaller
        quickSortHelperDevider(arr, start, smaller-1); //continue doing same for samller subarray
        quickSortHelperDevider(arr, smaller+1, end); //continue doing same for samller subarray
    }

    private static void swapWithinArray(int[] arr, int pos1, int pos2) {
        int temp = arr[pos2];
        arr[pos2] = arr[pos1];
        arr[pos1] = temp;
    }


}
