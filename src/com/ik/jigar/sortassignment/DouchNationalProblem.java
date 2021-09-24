package com.ik.jigar.sortassignment;

import java.util.Arrays;

public class DouchNationalProblem {

    public static void main(String[] args) {
        char[] arr = new char[]{'G','B','G','G','R','B','R','G','G','B','G','G','R','B','R','G','G','B','G','G','R','B','R','G','G','B','G','G','R','B','R','G'};
        DNCClassic(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }


    public static void dutch_flag_sort(char[] balls) {
        if(balls == null || balls.length <= 1){
            return;
        }
        int rIndex = 0, gIndex = 0, bIndex = balls.length -1;
        for (int i = 0; i <= bIndex; i++) {
            if(balls[i]=='R'){
                while(balls[rIndex] == 'R' && rIndex < i)
                    rIndex++;
                swap(balls,i,rIndex);
                //System.out.println("Red i:" + i + " rindex:" + rIndex + " bindex:" + bIndex + " arr = " + Arrays.toString(balls));
                rIndex++;
            } else if (balls[i] == 'B'){ // blue ball should go to blueIndex.  Go left until non blue found.  then swap
                while(balls[bIndex] == 'B' && bIndex >  i)
                    bIndex--;
                if(bIndex > i) {
                    swap(balls, i, bIndex);
                  //  System.out.println("Blue i:" + i + " rindex:" + rIndex + " bindex:" + bIndex + " arr = " + Arrays.toString(balls));
                    bIndex--;
                }
                if(balls[i] == 'R'){ // if swapped element is red then additional swap is needed
                    swap(balls, i, rIndex);
                    //System.out.println("Blue2 i:" + i + " rindex:" + rIndex + " bindex:" + bIndex + " arr = " + Arrays.toString(balls));
                    rIndex++;
                }
            }

        }
    }

    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     *  Need RGB
     * @param arr
     */
    static void DNCClassic(char arr[])
    {
        int low = 0, mid = 0, temp=0;// We use temporary variable for swapping
        int high = arr.length - 1;
        while(mid <= high){
            switch (arr[mid]){
                case 'R': // if left side
                    swap(arr, low, mid);
                    low++; // Increase low
                    mid++; // increase mid
                    break;
                case 'G':
                    mid++;
                    break;
                case 'B':
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    public static void dutch_flag_sort1(char[] balls) {
        int low = 0, mid = 0, temp=0;// We use temporary variable for swapping
        int high = balls.length - 1;
        while(mid <= high){
            switch (balls[mid]){
                case 'R': // if left side
                    swap(balls, low, mid);
                    low++; // Increase low
                    mid++; // increase mid
                    break;
                case 'G':
                    mid++;
                    break;
                case 'B':
                    swap(balls, mid, high);
                    high--;
                    break;
            }
        }
    }




}
