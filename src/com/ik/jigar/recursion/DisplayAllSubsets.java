package com.ik.jigar.recursion;

import java.util.*;

public class DisplayAllSubsets {
    public static void main(String[] args) {
        System.out.println(generate_all_subsets("abcd").toString());
    }

    /*
     * Complete the function below.
     */
    static List<String> generate_all_subsets(String s) {
        return generateSubsetRecursive(new ArrayList<String>(), s, new StringBuffer(), 0);
    }

    static List<String> generateSubsetRecursive(List<String> arr, String s, StringBuffer slate, int i){

        if(i >= s.length()){
            //System.out.println("inside arr = " + arr + ", s = " + s + ", slate = " + slate + ", i = " + i);
            arr.add(slate.toString());
            //System.out.println("arr after addition = " + arr);
            return arr;
        }

        //System.out.println("outside2 arr = " + arr + ", s = " + s + ", slate = " + slate + ", i = " + i);
        generateSubsetRecursive(arr,s ,slate.append(s.charAt(i)), i+1);
        // remove last char of slate if you want to use string buffer
        if(slate.length() > 0){
            slate.setLength(slate.length() - 1);
        }
        generateSubsetRecursive(arr, s, slate, i+1);

        return arr;
    }
}
