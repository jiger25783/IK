package com.ik.jigar.recursion;

import java.util.ArrayList;
import java.util.List;

public class WellFormedBrackets {

    public static void main(String[] args) {
        System.out.println(find_all_well_formed_brackets(2));
    }
    static String[] find_all_well_formed_brackets(int n) {
        List<String> res = new ArrayList<>();

        wellFrormedBrackets("", n*2, 0, 0, res);
        String[] result = new String[res.size()];
        int i = 0;
        for (String s:res) {
            result[i++] = s;
        };
        return result;
    }


    static void wellFrormedBrackets(String slate, int length, int leftCount, int rightCount, List<String> res){
        if(leftCount+rightCount >= length || slate.length() == length){
            System.out.println("gratr then length + " + length + " slate length " + slate.length() + ", slate = " + slate + ", left:" + leftCount + " , right " + rightCount);
            if(leftCount == rightCount)
                res.add(slate.toString());
            System.out.println("gratr then length + " + length + ", res = " + res);

            return;
        }
        //System.out.println("slate = " + slate);
        if(leftCount < length/2)
            wellFrormedBrackets(slate+"(", length, leftCount+1, rightCount, res);

        if(leftCount > rightCount) {
            /*if(slate.length() > 0){
                slate.setLength(slate.length() - 1);
            }*/
            wellFrormedBrackets(slate+")", length, leftCount, rightCount + 1, res);
        }
    }
}
