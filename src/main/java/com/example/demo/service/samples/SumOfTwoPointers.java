package com.example.demo.service.samples;

public class SumOfTwoPointers {

    public int[] solution(int[] source, int target){

        int leftPointer = 0;
        int rightPointer = source.length -1;

        while(leftPointer<rightPointer){
            int sum = source[leftPointer] + source[rightPointer];

            if(sum == target){ return new int[]{leftPointer + 1, rightPointer +1 };
            } else if(sum <target) {leftPointer++;}
            else {rightPointer--;}

        }
        return new int[]{-1, -1}; // Формальный возврат
    }
}
