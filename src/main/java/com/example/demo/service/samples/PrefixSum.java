package com.example.demo.service.samples;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrefixSum {


    public int[] makeTask(int[][] task){

        int[] result = {0, 0, 0};
        if(task.length ==4 && task[1].length==2 && task[2].length==2 && task[3].length==2){
            int[] mainArray = task[0];
            int[] firstPointers = task[1];
            int[] secondPointers = task[2];
            int[] thirdPointers = task[3];
            int[] prefixMain = prefixCounting(mainArray);
            result = sumRange(prefixMain, firstPointers, secondPointers, thirdPointers);
        }
        return result;
    }
    public int[] prefixCounting(int[] mainArray){
        int[] prefixMain = new int[mainArray.length +1];
        for(int i = 0; i < mainArray.length; i++){
            prefixMain[i + 1] = prefixMain[i] + mainArray[i];
        }
        return prefixMain;
    }
    public int[] sumRange(int[] prefixSums, int[] p1, int[] p2, int[] p3) {
        // Добавляем +1 к правому указателю, чтобы включить элемент в сумму
        int firstSum  = prefixSums[p1[1] + 1] - prefixSums[p1[0]];
        int secondSum = prefixSums[p2[1] + 1] - prefixSums[p2[0]];
        int thirdSum  = prefixSums[p3[1] + 1] - prefixSums[p3[0]];

        return new int[]{firstSum, secondSum, thirdSum};
    }
}
