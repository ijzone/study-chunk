package com.ij.study.warmUp.birthdayCakeCandles;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class BirthdayCakeCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        int tallest = 0;
        for(int candle : candles) {
            if(tallest < candle) {
                tallest = candle;
            }
        }
//        Integer maxHeight = candles.stream().max(Integer::compareTo).get();
//        System.out.println("maxHeight = " + maxHeight);

        int result = 0;
        for(int candle : candles) {
            if(tallest == candle) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("output")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).toList();

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
