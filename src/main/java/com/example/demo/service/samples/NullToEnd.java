package com.example.demo.service.samples;

public class NullToEnd {

    public int[] sorting(int[] source) {

        if (source == null || source.length == 0) {
            throw new RuntimeException();
        }
        int insertPoint = 0;
        for (int i = 0; i < source.length; i++) {


            if (source[i] != 0) {
                source[insertPoint] = source[i];
                insertPoint++;

            }
        }
        while(insertPoint<source.length){

            System.out.println(source[insertPoint]);
            source[insertPoint++] =0;

        }

        return source;
    }
}
