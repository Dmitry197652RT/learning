package com.example.demo.service.samples;

import com.example.demo.service.samples.PrefixSum;
import com.example.demo.service.samples.SubArraysEqualK;

public class MainForPrefix {
    public static void main(String[] args) {
        int[][] task = new int[][]{
                {3, -1999, 5, -6, 8, 0, -2},
                {1, 5},
                {0, 3},
                {2, 4}
        };

        PrefixSum prefixSum = new PrefixSum();
        int[] result = prefixSum.makeTask(task);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
        int[] sample = {1, 1, 1, 2, 1, 1, 1};
        SubArraysEqualK subArraysEqualK = new SubArraysEqualK();
        System.out.println(subArraysEqualK.countSubArrays(sample, 3));
        SumOfTwoPointers sumOfTwoPointers = new SumOfTwoPointers();
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] dt = sumOfTwoPointers.solution(numbers, target);
        System.out.println(dt[0] + " " + dt[1]);
        int[] water = {1,8,6,2,5,4,8,3,7};
        ContainsTheMostWater containsTheMostWater = new ContainsTheMostWater();
        System.out.println(containsTheMostWater.containsTheMostWater(water));
        TwoPointers twoPointers = new TwoPointers();
        int[] water2 = {1,8,6,2,5,4,8,3,7};
        System.out.println(" " + twoPointers.maxArea(water2));

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(numbers, 15));
    }



}
