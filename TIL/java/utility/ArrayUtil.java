package utility;

public class ArrayUtil {

    public static void main(String[] args) {
        int[] arr = {5, -1, 9, 1, 5, 6};
        minimumValueReturn(arr);
    }

    // 배열 최솟 값 찾기
    static int minimumValueReturn(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array can not be null or empty");
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        System.out.println("최솟값: " + arr[minIndex]);

        return arr[minIndex];
    }
}
