package com.ik.jigar.vmware;





// # Given a Unicode string of any length, determine the highest number of consecutive repetitions of every unicode character in the string and return some of object that contains this info.

// # For example, given the string “aabcb bbccdfaaabbddd” would return the information: a=3, b=2, c=2, d=3, f=1, Space=1.
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        printMaxDuplicate(" aaaabcb   bbccdfaaabbbddd");
    }

    //couter = 2
    //cur = b
    // pre = a
    // Sol map
    // a=2
    // b=1

    private static void printMaxDuplicate(String input){
        if(input == null || input.length() < 1){
            return;
        }
        Map<String, Integer> solutionMap = new HashMap<String, Integer>();
        //Map<Character, Integer> currentMap = new HashMap<Character, Integer>();
        Arrays.sort("this is the string".toCharArray());

        String curr;
        String pre = null;
        int currntCount = 1;
        for(int i=0; i< input.length(); i++){  // First pass
            curr = Character.toString(input.charAt(i));
            if(pre != null && pre.equals(curr)){
                currntCount++;
                // check if soulutionmap has the char and if its count is < current count then update
                if(solutionMap.get(curr) == null){
                    solutionMap.put(curr, 1);
                }else if(solutionMap.get(curr) < currntCount){
                    solutionMap.put(curr, currntCount);
                }
            } else { //if(pre == null){
                if(solutionMap.get(curr) == null)
                    solutionMap.put(curr, 1);
                if(pre != null && !pre.equals(curr)){
                    currntCount = 1;
                }
            }
            pre = curr;
        }

        for(Map.Entry<String, Integer> item : solutionMap.entrySet()){
            System.out.print(item.getKey() + " = " + item.getValue() + "  ");
        }
    }

}