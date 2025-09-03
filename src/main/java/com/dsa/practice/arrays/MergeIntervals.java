package com.dsa.practice.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String ags[]) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int [][] result  = mergeThem(intervals);

        for (int [] re : result){
            System.out.println(re[0] + " : " + re[1]);
        }

    }

    static int [][] mergeThem(int [][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (arr1,arr2) -> arr1[0]-arr2[0]);

        int [] current = intervals[0];
        result.add(current);

        for(int [] interval : intervals) {
            int curEnd = current[1];
            int next = interval[0];
            int nextEnd = interval[1];

            if(curEnd >= next) {
                current[1] = Math.max(curEnd,nextEnd);
            } else {
                current = interval;
                result.add(current);
            }

        }

        return  result.toArray(new  int [result.size()] []);
    }
}
