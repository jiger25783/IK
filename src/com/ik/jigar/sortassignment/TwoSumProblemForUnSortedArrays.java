package com.ik.jigar.sortassignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSumProblemForUnSortedArrays {
    // Complete the function below.
    public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        Collections.sort(numbers);
        int start = 0, end = numbers.size() -1;

        while (start < end) {
            if ((numbers.get(start) + numbers.get(end)) == target) {//if sum is equal then return the start and end
                return Arrays.asList(start,end);
            } else if((numbers.get(start) + numbers.get(end)) < target){ // if sum less than target so increase start index, go right
                start++;
            } else{ // here sum is more than target so decrease end index, go left.
                end--;
            }
        }
        //Solution is not possible
        return Arrays.asList(-1,-1);
    }

}