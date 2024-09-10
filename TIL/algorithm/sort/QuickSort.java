package sort;

import java.util.Arrays;

/**
 * <pre>
 * - pivot 인덱스를 정한다.
 * - pivot 값을 기준으로 왼쪽 & 오른쪽 둘로 나누어서
 *   왼쪽에 pivot 값보다 큰 수가 있고, 오른쪽에 pivot 값보다 작은 수가 있으면
 *   두 값을 교환한다.
 * - 반복문 순회해서 작은 값 & 큰 값이 pivot 기준으로 정렬 되었으면 왼쪽 오른쪽 배열도 재귀함수로 정렬한다.
 * <a href="https://www.youtube.com/watch?v=7BDzle2n47c">참고</a>
 * </pre>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 7, 6, 10, 5, 9, 2, 1, 15, 7 };
        int pivotIdx = quickSort(arr, 0, arr.length - 1);
        System.out.println("pivotIdx = " + pivotIdx);
        System.out.println(Arrays.toString(arr));
    }

//        int[] arr = { 7, 6, 10, 5, 9, 2, 1, 15, 7 };
    static int quickSort(int[] arr, int lo, int hi) {
        int median = partition(arr, lo, hi);
        // check if the array has only one element, if not, go on sort for left side
        if(lo < median - 1){
            quickSort(arr, lo, median-1);
        }
        // check if the array has only one element, if not, go on sort for right side
        if(median < hi){
            quickSort(arr, median, hi);
        }
        return partition(arr, lo, hi);
    }

    static int partition(int[] arr, int lo, int hi) {
        int median = lo; // allocate pivot index
        int pivot = arr[median]; // pivot value
        int left = lo;
        int right = hi;

        // contact point of left and right side of sub-array
        while (left <= right) {
            // increase index until left side sub-array value is greater than pivot value
            while (arr[left] < pivot) left++;
            // decrease index until right side sub-array value is less than pivot value
            while (arr[right] > pivot) right--;

            if (left <= right) {
                // swap smaller and larger value
                swap(arr, left, right);
                // keep on inspection next index value
                left++;
                right--;
            }
        }

        // return median index of the array
        return left;
    }

    static void swap(int[] arr, int lo, int hi) {
        var temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

}
