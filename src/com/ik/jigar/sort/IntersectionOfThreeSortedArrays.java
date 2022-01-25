package com.ik.jigar.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;
import java.util.stream.IntStream;

public class IntersectionOfThreeSortedArrays {
    /*public static void main(String[] args) {
        System.out.println(find_intersection(Arrays.asList(1,2,3), new ArrayList<>(),Arrays.asList(2,2)).toString());
    }*/


    public static List<Integer> find_intersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        /*if(arr1.size() == 0 || arr2.size() == 0){
            res.add(-1);
            return res;
        }*/
        int a1 =0, a2=0, a3=0;
        while (a1 < arr1.size() && a2 < arr2.size() && a3 < arr3.size()) {
            if(arr1.get(a1) == arr2.get(a2) && arr1.get(a1) == arr3.get(a3)){
                res.add(arr1.get(a1));
                a1++;
                a2++;
                a3++;
            } else {
                int min = Math.min(arr1.get(a1), arr2.get(a2));
                min = Math.min(min, arr3.get(a3));
                if(arr1.get(a1) == min) a1++;
                if(arr2.get(a2) == min) a2++;
                if(arr3.get(a3) == min) a3++;
            }
        }
        if(res.size() == 0){
            res.add(-1);
        }
        return res;
    }


    public static List<Integer> find_intersection_of_two(List<Integer> arr1, List<Integer> arr2) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        int a1 =0, a2=0;
        if(arr1.size() == 0 || arr2.size() == 0){
            return new ArrayList<Integer>();
        }

        while (a1 < arr1.size() || a2 < arr2.size() ) {
            if(arr1.get(a1) == arr2.get(a2)){
                res.add(arr1.get(a1));
                a1++;
                a2++;
            } else {
                int min = Math.min(arr1.get(a1), arr2.get(a2));
                if(arr1.get(a1) == min) a1++;
                if(arr2.get(a2) == min) a2++;
            }
        }
        return res;
    }
}
