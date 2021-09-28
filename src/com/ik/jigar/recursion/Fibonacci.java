package com.ik.jigar.recursion;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
//354224848179261915075
public class Fibonacci {
    public static void main(String[] args) {
        int n = 100;
        System.out.println("Finonacci of " + n + " is " + fib(n));
        System.out.println("Finonacci of " + n + " withoutMap is " + fibWithoutMap(n, BigInteger.ZERO, BigInteger.ONE));
        System.out.println("fibMap = " + fibMap);
    }
    public  static  Map<Integer, BigInteger>fibMap = new HashMap<>();
    public static BigInteger fib(Integer n){
        if(n == 0){
            fibMap.put(n, BigInteger.ZERO);
            return BigInteger.ZERO;
        }
        if(n == 1 || n == 2){  // n <= 2
            fibMap.put(n, BigInteger.ONE);
            return BigInteger.ONE;
        }
        if(fibMap.get(n) != null){
            return fibMap.get(n);
        }
        BigInteger res =   (fibMap.get(n-1)  != null ? fibMap.get(n-1) : fib(n-1)).add((fibMap.get(n-2)  != null ? fibMap.get(n-2) : fib(n-2)));
        fibMap.put(n, res);
        return  res;
    }

    public static BigInteger fibWithoutMap(int n, BigInteger b1, BigInteger b2){
        if(n==0){
            return b1;
        }
        return fibWithoutMap(n-1, b2, b1.add(b2));
    }

    public static BigInteger fibIterative(int n){
        BigInteger ni = BigInteger.ZERO,ni_2 = BigInteger.ZERO, prev = BigInteger.ZERO;
        BigInteger res;
        for (int i = 0; i <= n; i++) {
            if(i == 1) {
                ni = BigInteger.ONE;
            }
            if(i > 2){
                ni_2 = prev;
            }
            System.out.println("ni_2 = " + ni_2);
            System.out.println("ni = " + ni);
            System.out.println("i = " + i);
            res = ni.add(ni_2);
            System.out.println("res = " + res);
            System.out.println("--------------");
            if(i!=1)
                prev = res;
        }
        return ni;
    }
}
