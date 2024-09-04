package sort;

/**
 * <pre>
 * - 버블정렬 보다 효율적
 * - 퀵 정렬, 힙 정렬, 머지 정렬 보다 비효율적
 * 시간 복잡도
 *   - 최악의 경우: O(n*n) -> 모든 배열 값이 전부 정렬 되지 않은 상태
 *   - 최선의 경우: O(n) -> 모든 배열 값이 전부 정렬 되어있는 상태
 * pros:
 *   - 간단
 *   - 작은 크기의 배열에 사용하기는 성능 상 괜찮음
 *   - 정해진 공간 내에서 정렬하기 때문에 필요 공간을 최소화 할 수 있음
 * cons:
 *   - 다른 개선된 정렬 알고리즘에 비해 낮은 성능
 *   - n개의 요소를 정렬 하려면 n제곱 단계가 필요하기 때문에 큰 크기의 리스트에 사용하기에는 부적합
 * <a href="https://www.javacodegeeks.com/2020/06/java-program-to-insertion-sort.html">참고</a>
 * </pre>
 */
public class InsertionSort {

    public static void main(String[] args) {
        // input array
        int[] inputArray = { 6, 5, 3, 1, 8, 7, 2, 4 };
        int length = inputArray.length;
        int j;

        System.out.print("Before Sorting: ");
        printArray(inputArray);
        System.out.print("\nValues for each Iteration");

        for (int i = 1; i < length; i++) {
            j = i - 1;
            int key = inputArray[i];
            while (j >= 0 && inputArray[j] > key) { // 현재 순회 중인 인덱스에 해당하는 값인 키 값을 기준으로 왼쪽 인덱스 값보다 작은 지 하나씩 검사
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j + 1] = key;
            System.out.println();
            printArray(inputArray);
        }

        System.out.print("\nAfter sorting: ");
        printArray(inputArray);
        System.out.println();
    }

    private static void printArray(int[] inputArray) {
        for (int value : inputArray) {
            System.out.print(value + " ");
        }
    }
}
