package com.example.demo.service.samples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsTheMostWater {
// найти результат умножения двух наибольших чисел
    public int containsTheMostWater(int[] water) {
        Arrays.sort(water);
        int[] unique = Arrays.stream(water).distinct().toArray();
        if (hasRepeatedValues(water, unique)) {

        }
        for (int i = 0; i < water.length; i++) {
            List<Integer> repeatedValues = Arrays.stream(water)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .toList();

            if (repeatedValues.contains(water[water.length -1])) {
                return water[water.length - 1] * water[water.length - 1];

            }


        }
        return water[water.length - 1] * water[water.length -2];
    }
    public boolean hasRepeatedValues ( int[] water, int[] unique){
        if (water.length == unique.length) {
            return false;
        }
        return true;
    }
}
