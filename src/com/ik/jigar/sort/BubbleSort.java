package com.ik.jigar.sort;

import java.util.Arrays;

public class BubbleSort {
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
        Arrays.stream(bubbleSort(arr)).forEachOrdered(System.out::println);
    }

    private static int[]  bubbleSort(int[] arr) {
        if(arr.length <=1)
            return arr;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
