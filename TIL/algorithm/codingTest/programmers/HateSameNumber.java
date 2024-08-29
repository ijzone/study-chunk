package codingTest.programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 같은 숫자는 싫어
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
 * @ex
 * 1. arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * 2. arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 *
 * @restrictions
 * 1. 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 2. 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12906">같은 숫자는 싫어</a>
 */
public class HateSameNumber {

    private static int[] arr = {1, 1, 3, 3, 0, 1, 1};
    private static int[] arr2 = {4, 4, 4, 3, 3};

    public static void main(String[] args) {
        int[] answer = eliminateDuplicatedNumberArray(arr);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] eliminateDuplicatedNumberArray(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int n : arr) {
            System.out.println(n);
            if(stack.isEmpty()) {
                stack.push(n);
            }

            if(stack.peek() != n) {
                stack.push(n);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("stack: " + stack.get(i));
            result[i] = stack.get(i);
        }

        return result;
    }
}
