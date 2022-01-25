package com.ik.jigar.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicDecompositions {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate_palindromic_decompositions("abracadabra")));
    }

    static String[] generate_palindromic_decompositions(String s) {

    List<String> result = new ArrayList<>();
    return palindromicDecompositions(s, result, "", 0);
    }

    static String[] palindromicDecompositions(String s, List<String> res, String slate, int i){
        if( i>= s.length()){
            if(isPalindromicString(slate)){
                res.add(slate);
            }
            return res.toArray(new String[0]);
        }

        palindromicDecompositions(s, res, slate, i+1);
        palindromicDecompositions(s, res, slate+s.charAt(i), i+1);
        return res.toArray(new String[0]);
    }

    private static boolean isPalindromicString(String slate) {
        int i=0, j=slate.length()-1;
        while (i<j){
            if(slate.charAt(i) != slate.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return  true;
    }
}
