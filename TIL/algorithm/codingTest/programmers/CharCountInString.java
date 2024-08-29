package codingTest.programmers;

/**
 * 문자열 내 p와 y의 개수
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 *  @restrictions
 * 1. 문자열 s의 길이 : 50 이하의 자연수
 * 2. 문자열 s는 알파벳으로만 이루어져 있습니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12916">문자열 내 p와 y의 개수</a>
 */
public class CharCountInString {

    private static final String s = "pPoooyY";
//    private final String s = "Pyy";

    public static void main(String[] args) {
        System.out.println("=====");
        System.out.println("Answer: " + isEqualCount(s));
    }

    public static boolean isEqualCount(String s) {
        if(s.length() < 1 || s.isBlank()) {
            return false;
        }

        int pCnt = 0;
        int yCnt = 0;

        char[] strArr = String.valueOf(s).toCharArray();
        for (char c : strArr) {
            if("p".equalsIgnoreCase(String.valueOf(c))) {
                pCnt += 1;
            }
            if("y".equalsIgnoreCase(String.valueOf(c))) {
                yCnt += 1;
            }
            System.out.println(c);
        }
        System.out.println("p count: " + pCnt + " y count: " + yCnt);
        if(pCnt != yCnt) {
            return false;
        }

        return true;
    }
}
