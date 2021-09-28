package com.ik.jigar.recursion;

public class PowerCalc {
    public static void main(String[] args) {
        int n=5, k=2;
        System.out.println("n to the power of k is: " + pow(n,k));
    }
    public static int pow(int n, int k){
        if(k == 0){
            return  1;
        }
        return n * pow(n, k-1);
    }
}
