package codingTest.programmers;

import java.util.Arrays;

/**
 * 정수 내림차순으로 배치하기
 * 함수 solution은 정수 n을 매개변수로 입력받습니다.
 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 *
 * @restrictions
 * 1. n은 1이상 8000000000 이하인 자연수입니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12933">정수 내림차순으로 배치하기</a>
 */
public class IntegerDescendingOrder {

    private static long n = 118372;
    public static void main(String[] args) {
        long answer = integerDesc(n);
        System.out.println("answer: " + answer);
    }

    public static long integerDesc(long n) {
        char[] c = String.valueOf(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(c);

        for (int i = c.length-1; i >= 0; i--) {
            sb.append(String.valueOf(c[i]));
        }
        System.out.println(sb.toString());
        return Long.parseLong(sb.toString());
    }
}
