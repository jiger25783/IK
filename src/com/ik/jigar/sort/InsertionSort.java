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
        arr[maxPos+1] = key;  // Covering edge cases as maxPos will be always at one less then where key could be
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
        Arrays.sort(new int[] {4,5,6,7,8,94,3,2,2});
    }


    private static void insertionSortRecursive2(int[] arr,int n){
        if(arr == null || n < 2) return;
        insertionSortRecursive2(arr, n-1);
        int key = arr[n-1];
        int i = n-2;
        while(i >= 0 && arr[i] > key){
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = key;
    }

}
