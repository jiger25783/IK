package com.ik.jigar.dp;

import java.util.List;

public class NumberOfPaths {

    public static int numberOfPaths(List<List<Integer>> matrix) {
        // Write your code here
        double[][] res = new double[matrix.size()][matrix.get(0).size()];
        res[0][0] = 1;

        // fill first row
        for(int col = 0; col < matrix.get(0).size(); col++){
            if(matrix.get(0).get(col) != 1){
                break;
            }
            res[0][col]=1;
        }
        // fill first column
        for(int row = 0; row < matrix.size(); row++){
            if(matrix.get(row).get(0) != 1){
                break;
            }
            res[row][0]=1;
        }
        for(int i=1; i < matrix.size(); i++){
            for(int j=1; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j) == 1){
                    res[i][j] = res[i-1][j] + res[i][j-1];
                    /*if(i-1 >=0 && matrix.get(i-1).get(j) == 1){
                        res[i][j] += res[i-1][j];
                    }

                    if(j-1 >= 0 && matrix.get(i).get(j-1) == 1){
                        res[i][j] += res[i][j-1];
                    }*/
                }
            }
        }
        return (int)res[matrix.size()-1][matrix.get(0).size()-1];
    }

    static long max_product_from_cut_pieces(int n) {
        /*
         * Write your code here.
         */

        int mid = n/2;
        if(n%2 == 0){
            return mid*mid;
        }

        return mid * (mid+1);

    }
}
