package codingTest.programmers;

import java.util.Arrays;

/**
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 * 1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 3. 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * @restrictions
 * 1. array의 길이는 1 이상 100 이하입니다.
 * 2. array의 각 원소는 1 이상 100 이하입니다.
 * 3. commands의 길이는 1 이상 50 이하입니다.
 * 4. commands의 각 원소는 길이가 3입니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42748">K번째수</a>
 */
public class KthNumber {

    private static int[] array = {1, 5, 2, 6, 3, 7, 4};
    private static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    public static void main(String[] args) {
        numberArray(array, commands);
    }

    public static int[] numberArray(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
//            System.out.println(Arrays.toString(commands[i]));
            answer[i] = nthNumber(array, commands[i]);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static int nthNumber(int[] a, int[] c) {
//        System.out.println("a: " + Arrays.toString(a));
//        System.out.println("c: " + Arrays.toString(c));

        int begin = c[0] - 1;
        int end = c[1];
        int numIdx = c[2] - 1;

        int[] resultArr = Arrays.copyOfRange(a, begin, end);
        Arrays.sort(resultArr);
        System.out.println(Arrays.toString(resultArr));

        return resultArr[numIdx];
    }
}
