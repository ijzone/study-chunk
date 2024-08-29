package codingTest.programmers;

/**
 * 타겟 넘버
 */
public class TargetNumber {

    static int[] numbers = {1,1,1,1,1};
    static int target = 3;
//    static int[] numbers = {1,4,2,1};
//    static int target = 4;
    static int count = 0;


    public static void main(String[] args) {
        dfs(numbers, 0, target, 0);
        System.out.println("\nCount: " + count);
    }

    public static void dfs(int[] numbers, int depth, int target, int sum) {
        System.out.print(sum + " ");
        if(depth == numbers.length) {
            if(target == sum) {
                count++;
            }
            return;
        }

        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }
}
