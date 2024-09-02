package sort;

import java.util.Arrays;

/**
 * <pre>
 * - 배열을 순회하면서 index와 index+1을 비교해서 큰 값을 뒤로 보내서 정렬
 * - 배열의 크기만큼 한번 순회가 완료되면 가장 큰 수가 마지막에 위치하게 되기 때문에
 *   그 다음 배열이 순회 할 때는 정렬이 완료된 마지막 인덱스 -1 까지만 순회한다.
 * </pre>
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        bubbleSort(arr);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // O(n^2)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
