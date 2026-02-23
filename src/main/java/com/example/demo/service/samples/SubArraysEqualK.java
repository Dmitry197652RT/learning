package com.example.demo.service.samples;

import java.util.HashMap;
import java.util.Map;

public class SubArraysEqualK {

    public int countSubArrays(int[] sample, int k) {
        int count = 0;
        int currentSum = 0;

        // Ключ: значение префиксной суммы
        // Значение: сколько раз эта сумма встретилась ранее
        Map<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);

        for(int i = 0; i<sample.length; i++)
        {
            // 1. Накапливаем текущую префиксную сумму
            currentSum +=sample[i];

            if (prefixSum.containsKey(currentSum - k)) {
                count += prefixSum.get(currentSum - k);

            }
            // 3. Записываем текущую префиксную сумму в карту
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
            System.out.println(count);
        }


        return count;
    }

}
