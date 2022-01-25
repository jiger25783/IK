package com.ik.jigar.recursion;

import java.util.Arrays;

public class GenerateAllSubset {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate_all_subsets("abc")));
    }
    static String[] generate_all_subsets(String s) {
        int size = (int) Math.pow(2,s.length());
        return generateSubsetRecursive(new String[size], s, "", 0, new int[]{0});
    }

    static String[] generateSubsetRecursive(String[] arr, String s, String slate, int i, int[] arrCounter){
        System.out.println("arr = " + Arrays.deepToString(arr) + ", s = " + s + ", slate = " + slate + ", i = " + i);
        if(i >= s.length()){
            System.out.println("adding to arr["+ arrCounter[0]+ "] :" + slate);
            arr[arrCounter[0]++] = slate;
            return  arr;
        }
        generateSubsetRecursive(arr, s, slate + s.charAt(i), i+1, arrCounter);
        generateSubsetRecursive(arr, s, slate,i+1, arrCounter);
        return  arr;
    }

}
