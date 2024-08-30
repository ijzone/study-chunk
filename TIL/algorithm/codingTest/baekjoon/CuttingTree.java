package codingTest.baekjoon;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * todo: 2805번: 나무 자르기
 * <a href="https://www.acmicpc.net/problem/2805">나무 자르기</a>
 */
public class CuttingTree {

    static int[][] arr;

    public static void main(String[] args) {
        arr = testInputData();
        int[] treeCountAndNeededLength = arr[0];
        int[] trees = arr[1];
        System.out.println("trees = " + Arrays.toString(trees));
        Arrays.sort(trees);
        System.out.println("sorted trees = " + Arrays.toString(trees));

    }

    // 테스트 데이터
    static int[][] testInputData() {
        return new int[][] {{4, 7}, {20, 15, 10, 17}};
//        return new int[][] {{5, 20}, {4, 42, 40, 26, 46}};
    }

    static int solution(int lengthOfNeed, int[] trees) {
        Arrays.sort(trees); // 나무 크기 정렬

        int cutLength = 0;
        int start = 0;
        int end = 2_000_000_000;

        TreeMap<?, ?> treeMap = new TreeMap<>();

        return 0;
    }
}
