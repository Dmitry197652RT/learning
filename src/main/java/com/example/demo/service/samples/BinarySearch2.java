package com.example.demo.service.samples;

import java.util.Arrays;

public class BinarySearch2 {

    int binSearch(int[] sample, int key){
        int[] sorted = sortInts(sample);
        int left = 0;
        int right = sorted.length -1;
        if (key < sorted[0] || key > sorted[right]) return -1;

        int mid = 0;

        while(left  <= right){
            mid = left + (right - left) / 2;
            if (sorted[mid] == key) {
                return mid;
            } else if (sorted[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            }
        return -1;


    }

    public int[] sortInts(int[] sample){

        int[] copy = Arrays.copyOf(sample, sample.length);
        Arrays.sort(copy);
        return copy;
    }
public int standartBinSearch(int[] sample, int key){
        int[] sorted = sortInts(sample);
        int result = Arrays.binarySearch(sorted, key); // Исправили 5 на key


    return (result >= 0) ? result : -1;
}

}
