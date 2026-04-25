package com.practice.algorithm.intervals;

import java.util.*;

public class MergeInterval {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval[] intervals = {
            new MergeInterval().new Interval(1, 3),
            new MergeInterval().new Interval(2, 4),
            new MergeInterval().new Interval(5, 7),
            new MergeInterval().new Interval(6, 8)
        };
        
       Interval[] result = mergeIntervals(intervals);
         System.out.println("Merged Intervals:");
        for (Interval interval : result) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }

    public static Interval[] mergeIntervals(Interval[] intervals) {
        //sort the intervals based on start time
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1.start,i2.start));
        List<Interval> mergedList = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            //check if the current interval overlaps with the previous one
            if(intervals[i+1].start <= intervals[i].end){
                //merge the intervals by updating the end time of the current interval
                mergedList.add( new MergeInterval().new Interval(intervals[i].start,Math.max(intervals[i].end,intervals[i+1].end)));
                i++; //skip the next interval as it is merged
            }
        }
        Interval[] mergedIntervals = new Interval[mergedList.size()];
        return mergedIntervals;
    }
    
}
