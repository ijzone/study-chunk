package sort;

import java.util.Arrays;

/**
 * <pre>
 * - 배열을 순회하면서 가장 작은 값의 인덱스를 찾아 현재 돌고 있는 인덱스의 값과 교환
 * - 시간 복잡도: O(n^2)
 * <a href="https://www.javacodegeeks.com/2020/11/selection-sort-in-java-with-algorithm-example.html">참고</a>
 * </pre>
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] inputArry = { 5, 9, 3, 1, 7 };
        int length = inputArry.length;
        int minValueIndex;

        System.out.print("Before sorting input array: ");
        printInputArray(inputArry);

        for (int i = 0; i < length; i++) {
            minValueIndex = i;
            for (int j = i; j < length; j++) {
                if (inputArry[minValueIndex] > inputArry[j]) {
                    minValueIndex = j;
                }
            }

            int temp = inputArry[minValueIndex];
            inputArry[minValueIndex] = inputArry[i];
            inputArry[i] = temp;
            System.out.print("\nIterate: " + i + " : ");
            printInputArray(inputArry);
        }
        System.out.print("\nAfter sorting input array: ");
        printInputArray(inputArry);
    }

    private static void printInputArray(int[] values) {
        System.out.print("values = " + Arrays.toString(values));
    }
}
