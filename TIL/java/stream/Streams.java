package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Streams {

    static int[] intArr = {5, 5, 6};
    static String[] strArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

    public static void main(String[] args) {
        aggregation(intArr);
        integerReduction(intArr);
        stringReduction(strArr);
    }

    // Primitive Streams 👇
    static void aggregation(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        var sum = list.stream().mapToInt(Integer::intValue).sum();
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        int min = list.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
        System.out.println("min = " + min);
        System.out.println("==========================");
    }

    // Integer Reduction
    static void integerReduction(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        Integer multiply = list.stream().reduce(3, (a, b) -> a * b);
        // using BinaryOperator
        BinaryOperator<Integer> multiplyOperator = (a, b) -> a * b;
        Integer multiply2 = list.stream().reduce(3, multiplyOperator);

        Integer reduceSum = list.stream().reduce(0, Integer::sum);

        System.out.println("multiply = " + multiply);
        System.out.println("reduceSum = " + reduceSum);
        System.out.println("multiply2 = " + multiply2);
        System.out.println("==========================");
    }

    // String Reduction
    static void stringReduction(String[] arr) {
        List<String> list = Arrays.stream(arr).toList();
        String concat = list.stream().reduce("", (a, b) -> a + b);
        String concat2 = list.stream().reduce("", String::concat);

        BinaryOperator<String> uppercaseOperator = (a, b) -> a.toUpperCase() + b.toUpperCase();
        String concat3 = list.stream().reduce("", uppercaseOperator);

        System.out.println("concat = " + concat);
        System.out.println("concat2 = " + concat2);
        System.out.println("concat3 = " + concat3);

//        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
//        int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
//        System.out.println("computedAges = " + computedAges);
        System.out.println("==========================");
    }

}
