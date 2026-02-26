package com.example.demo.service.samples;

public class BinarySearch {
    // Условие: Дан отсортированный массив целых чисел arr и целое число target (цель). Напишите функцию,
    // которая возвращает индекс target в arr, если число существует, иначе возвращает -1.
    // Вход: arr = [-5, 2, 4, 7, 8, 10, 15], target = 8
    // Выход: 4 (индекс числа 8)
    public int search(int[] arr, int target){
        int firstIndex = 0;
        int lastIndex = arr.length -1;

        while(firstIndex <= lastIndex)
        {
            int mid = firstIndex + (lastIndex - firstIndex) / 2;
            if(arr[mid]== target){
                return mid;
            }
            if(arr[mid]<target) {
                firstIndex = mid+1;
            }
            else if(arr[mid]>target){
                lastIndex = mid-1;
            }
        }
        return -1;
    }


}
