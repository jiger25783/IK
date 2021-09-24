package com.ik.jigar.sortassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("Soultion is : " + merge_sort(Arrays.asList(7,5,8,3,9,4,1,7)).toString());
    }
    static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here.
        if(arr == null || arr.size() <=1){
            return (ArrayList<Integer>)arr;
        }

        return mergeSort(arr, 0, arr.size()-1);
    }

    static List<Integer> mergeSort(List<Integer> arr, int start, int end){
        if(start >= end){
            return arr;
        }
        int mid = (start/2 + end/2);
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
        return arr;
    }

    static void merge(List<Integer> arr, int start, int mid, int end){

        int i1 = start;
        int i2 = mid+1;
        ArrayList<Integer> result = new  ArrayList<Integer>();
        while(i1 <= mid && i2 <= end){
            if(arr.get(i1) <= arr.get(i2)){
                result.add(arr.get(i1));
                i1++;
            } else{
                result.add(arr.get(i2));
                i2++;
            }
        }

        while(i1 <= mid){
            result.add(arr.get(i1));
            i1++;
        }

        while(i2 <= end){
            result.add(arr.get(i2));
            i2++;
        }
        i1 = start;
        for (int i = 0; i < result.size(); i++) {
            arr.set(i1, result.get(i));
            i1++;
        }
    }
}
