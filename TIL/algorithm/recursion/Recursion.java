package recursion;

/**
 * Recursion call
 * @see <a href="http://tcpschool.com/java/java_usingMethod_recursive">재귀 호출</a>
 */
public class Recursion {

	public static void main(String[] args) {
		int sum = recursiveSum(5);
		System.out.printf("recursiveSum: %d\n", sum);

		int[] arr = {0, 80, 60, 40, 20, 100};
		int arrayMaxVal = arrayMaxValue(arr, 6);
		System.out.printf("arraySort: %d\n", arrayMaxVal);
	}
	
	static int recursiveSum(int n) {
		if(n == 1) {
			return 1;
		}
		
//		System.out.printf("Current value: %d\n", n);
		return n + recursiveSum(n-1);
	}
	
	
	/**
	 * 배열에서 최대값 찾기
	 * @param arr 배열
	 * @param range 범위
	 * @return
	 */
	static int arrayMaxValue(int[] arr, int range) {
		int x;
		if(range == 1) {
			return arr[range-1];
		}
		
		x = arrayMaxValue(arr, range-1);

		return x > arr[range-1] ? x : arr[range-1];
	}
}
