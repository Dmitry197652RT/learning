package com.example.demo.service.samples;



public class TwoPointers {

    public int maxArea(int[] sample){

        int maxArea = 0;
        int left = 0;
        int right = sample.length -1;

        while(left<right){

            int width = right - left; // ширина бассейна

            int minWater = Math.min(sample[left], sample[right]);// минимальный уровень воды для данной
            // итерации
            int waterLevel = width * minWater; // общий обьем воды для данной итерации
            maxArea = Math.max(maxArea, waterLevel); // если обьем воды для данной итерации максимален он
            // становится основным значением
            if(sample[left] < sample[right]){
                left++;
            }else{
                right--;
            }

        }
    return maxArea;
    }
}
