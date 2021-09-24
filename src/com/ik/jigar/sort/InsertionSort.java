package com.ik.jigar.sort;

import java.util.Arrays;

public class InsertionSort {
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
        System.out.println("Sorted array is :");
        //insertionSortIterative(arr);
        insertionSortRecursive(arr, arr.length);
        Arrays.stream(arr).forEachOrdered(System.out::println);
    }



    private static void insertionSortRecursive(int[] arr,int n){
        if(n <= 1)
            return;
        insertionSortRecursive(arr, n-1);
        int key = arr[n-1];
        int maxPos = n-2;
        while(maxPos >=0 && arr[maxPos] > key){
            arr[maxPos + 1] = arr[maxPos];
            maxPos --;
        }
        arr[maxPos+1] = key;
        return;
    }

    private  static  void insertionSortIterative(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
