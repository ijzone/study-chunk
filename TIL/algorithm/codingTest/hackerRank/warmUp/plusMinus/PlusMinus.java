package codingTest.hackerRank.warmUp.plusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        int denominator = arr.size();
        int plusCount = 0;
        int minusCount = 0;
        int zeroCount = 0;
        for(Integer num : arr) {
            if(num < 0) {
                minusCount++;
            } else if(num > 0) {
                plusCount++;
            } else {
                zeroCount++;
            }
        }

        double plusRatio = (double) plusCount / denominator;
        double minusRatio = (double) minusCount / denominator;
        double zeroRatio = (double) zeroCount / denominator;
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println(df.format(plusRatio));
        System.out.println(df.format(minusRatio));
        System.out.println(df.format(zeroRatio));
    }

    public static void main(String[] args) throws IOException {
//        var arr = new ArrayList<Integer>();
//        arr.add(1);
//        arr.add(0);
//        arr.add(0);
//        arr.add(-1);
//        arr.add(-1);
//        arr.add(1);
//        arr.add(-1);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }
}
