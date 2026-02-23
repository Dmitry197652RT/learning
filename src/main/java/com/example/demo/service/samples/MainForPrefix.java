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

    }


}
