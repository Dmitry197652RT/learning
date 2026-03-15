package com.example.demo.service.samples;

import java.util.Arrays;
import java.util.Comparator;

public class MaxInt {



    public int makeMax(int sample){
        String fromInt = Integer.toString(sample);
        int[] fromstring = new int[fromInt.length()];
        for(int i =0; i<fromInt.length(); i++){
            char c = fromInt.charAt(i);
            int fromChar = c - '0';
            fromstring[i] = fromChar;
        }
        int[] sorted = Arrays.stream(fromstring)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int result = 0;
        for (int d : sorted) {
            result = result * 10 + d;
        }
    return result;
    }
}
