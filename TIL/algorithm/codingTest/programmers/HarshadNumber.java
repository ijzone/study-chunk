package codingTest.programmers;

public class HarshadNumber {

    private static int x = 10;

    public static void main(String[] args) {
        boolean answer = isHarshad(x);
        System.out.println("answer: " + answer);
    }

    public static boolean isHarshad(int x) {
        String str = String.valueOf(x);
        int sum = 0;
        for(char c : str.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }

        System.out.println("Sum: " + sum);

        return (x%sum) == 0 ? true : false;
    }
}
