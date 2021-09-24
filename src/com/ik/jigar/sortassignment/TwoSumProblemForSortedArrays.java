package com.ik.jigar.sortassignment;

import java.util.*;

public class TwoSumProblemForSortedArrays {

    public static void main(String[] args) {
        System.out.println("Answer is :" + pair_sum_sorted_array(Arrays.asList(5,1,10,45,9), 6));
    }
    // Complete the function below.
    public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        Map<Integer, Integer>valIndexMap = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            int searchFor = target - numbers.get(i);
            if(valIndexMap.get(searchFor) != null){
                return Arrays.asList(valIndexMap.get(searchFor), i);
            }
            if(valIndexMap.get(numbers.get(i)) == null){
                valIndexMap.put(numbers.get(i), i);
            }
        }
        //Solution is not possible
        return Arrays.asList(-1,-1);
    }

}