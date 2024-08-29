package codingTest.programmers;

/**
 * 문자열을 정수로 바꾸기
 * 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
 *
 * @restrictions
 * 1. s의 길이는 1 이상 5이하입니다.
 * 2. s의 맨앞에는 부호(+, -)가 올 수 있습니다.
 * 3. s는 부호와 숫자로만 이루어져있습니다.
 * 4. s는 "0"으로 시작하지 않습니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12925">문자열을 정수로 바꾸기</a>
 */
public class StringToInteger {

    private static String s = "1234";

    public static void main(String[] args) {
        System.out.println("answer: " + convertToInteger(s));
    }

    public static int convertToInteger(String s) {
        boolean sign = true;
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println("index: " + i);
            System.out.println("ch: " + ch);
            if(ch == '-') {
                sign = false;
            }else if (ch != '+') {
                result = result * 10 + (ch - '0');
//                System.out.println("result: " + result);
            }
        }

        return sign ? 1 * result : -1 * result;
    }
}
