package codingTest.codility;

import java.util.Arrays;

/**
 * Missing Integer
 *
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 *
 * @conditions
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
//        int[] A = {1, 2, 3};
//        int[] A = {-1, -3};

        System.out.println("Answer: " + solution(A));
    }

    private static int solution(int[] a) {
        int result = 1; // 최소 0보다 큰수여야 하기 때문에 최소값 1로 설정.
        Arrays.sort(a); // 오름차순 정렬
        System.out.println("a = " + Arrays.toString(a));

        for (int num : a) {
            if (num == result) {
                result++; // 정렬된 배열 요소를 순환하면서 담겨있는 최소값보다 1씩 증가. 0보다 작은 수일 경우, 1에서 증가하지 않음.
            }
        }

        return result;
    }
}
