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
        int[] arr = new int[]{6,5,3,2,6,6,6,6,6,5,6,6,6,6,6,6,3,1,54,22,11,4};
        quickSortRecursive(arr);
        System.out.println("Sorted array is :");
        Arrays.stream(arr).forEachOrdered( str -> System.out.print(str + " "));
    }



    private static void quickSortRecursive(int[] arr){
        if(arr.length <= 1)
            return;
        //quickSortHelperDevider(arr, 0, arr.length -1);
        //quickSortHelperDeviderLamuto(arr, 0, arr.length -1);
        quickSortHelperDeviderHoare(arr, 0, arr.length -1);
    }

    /**
     * This is lamuto's way of partitionoing when doing quick sort
     * @param arr
     * @param start
     * @param end
     */
    private static void quickSortHelperDeviderLamuto(int[] arr, int start, int end) {
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
        Arrays.stream(arr).forEachOrdered( str -> System.out.print(str + " "));
        quickSortHelperDeviderLamuto(arr, start, smaller-1); //continue doing same for samller subarray
        quickSortHelperDeviderLamuto(arr, smaller+1, end); //continue doing same for samller subarray
    }

    private static void swapWithinArray(int[] arr, int pos1, int pos2) {
        int temp = arr[pos2];
        arr[pos2] = arr[pos1];
        arr[pos1] = temp;
    }

    private static void quickSortHelperDeviderHoare(int[] arr, int start, int end) {
        //Base condition
        if(start >= end || arr.length <= 1){
            return;
        }

        int smaller = start+1;
        int bigger = end;
        int pivotPos = ThreadLocalRandom.current().nextInt(start, end+1);
        swapWithinArray(arr, start, pivotPos);

        while (bigger >= smaller){

            if(arr[smaller] <= arr[start])
                smaller++;
            else if(arr[bigger] > arr[start])
                bigger--;
            else
                swapWithinArray(arr,bigger,smaller);
        }
        swapWithinArray(arr, start, bigger); // Move pivot to smaller location which will be final location for it
        quickSortHelperDeviderHoare(arr, start, bigger -1);
        quickSortHelperDeviderHoare(arr, bigger+1, end);
    }


}
