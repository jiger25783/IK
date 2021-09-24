package com.ik.jigar.sortassignment;

import java.util.Collections;
import java.util.List;

public class AttendMeetings {

    /*
    Complete the function below.
    */
    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
        //First sort meetings in assending order of the start time
        Collections.sort(intervals, (a,b)->{
            return a.get(0) - b.get(0);
        });


        for (int i = 0; i < intervals.size() -1; i++) {
            //Since meetins are sorted now in starting order time
            // we can check if end time of current meeting is overlapping with start time of next
            // if it do not overlap with next then it will not overlap with any of the remaining once
            if(intervals.get(i).get(1) > intervals.get(i+1).get(0)){
                /*
                System.out.println("i = " + i);
                System.out.println("intervals.get(i) = " + intervals.get(i));
                System.out.println("intervals.get(i+1) = " + intervals.get(i+1));
                */
                return 0;
            }
        }
        return 1;
    }

}
