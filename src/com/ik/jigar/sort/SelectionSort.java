package com.ik.jigar.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
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
        Arrays.stream(selectionSort(arr)).forEachOrdered(System.out::println);
    }

    private static int[]  selectionSort(int[] arr) {
        if(arr.length <=1)
            return arr;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            if(i != minIndex){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
