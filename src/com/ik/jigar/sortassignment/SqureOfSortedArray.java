package com.ik.jigar.sortassignment;

public class SqureOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int[] res = new int[nums.length];
        int right = nums.length -1;
        int resCounter = nums.length;
        while (left <= right){
            int leftVal = nums[left];
            int rightVal = nums[right];
            if( leftVal*leftVal <= rightVal*rightVal){
                res[--resCounter] = rightVal*rightVal;
                right--;
            } else {
                res[--resCounter] = leftVal*leftVal;
                left++;
            }
        }
        /*
        if(left < nums.length && resCounter >0){
            res[--resCounter] = nums[left]*nums[left];
        }*/
        return res;
    }
}
