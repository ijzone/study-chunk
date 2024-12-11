package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 3, 9, 4, 7, 5, 0, 1, 6, 8, 2 };
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int median = (start + end) / 2;
            mergeSort(arr, tmp, start, median); // 왼쪽
            mergeSort(arr, tmp, median + 1, end); // 오른쪽
            merge(arr, tmp, start, median, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int median, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = median + 1;
        int index = start; // 어느 인덱스에 저장 할 것 인지에 대한 정보를 가지고 있는 변수

        while (part1 <= median && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }

        for (int i = 0; i <= median - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }

}
