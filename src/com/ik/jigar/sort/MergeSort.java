package com.ik.jigar.sort;

import java.util.Arrays;

public class MergeSort {
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
        mergeSortRecursive(arr, 0, arr.length-1);
        System.out.println("Sorted array is :");
        Arrays.stream(arr).forEachOrdered(System.out::println);
    }



    private static void mergeSortRecursive(int[] arr, int left, int right){
        if(arr.length <= 1)
            return;
        if(left < right) {
            int mid = left + (right-left)/2; //This condition handles integer overflow if left+right is more than integer limit
            mergeSortRecursive(arr, left, mid);
            mergeSortRecursive(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        return;
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] arrtmp = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid+1;
        int i = 0;
        while(leftIndex <= mid && rightIndex <= right){
            if(arr[leftIndex] <= arr[rightIndex]) { // <= make sure its stable sort
                arrtmp[i++] = arr[leftIndex++];
            } else{
                arrtmp[i++] = arr[rightIndex++];
            }
        }
        while (leftIndex <= mid){
            arrtmp[i++] = arr[leftIndex++];
        }

        while (rightIndex <= right){
            arrtmp[i++] = arr[rightIndex++];
        }
        i=0;
        for (int j = left; j <= right; j++) {
            arr[j] = arrtmp[i++];
        }

        return;
    }
}
