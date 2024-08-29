package codingTest.programmers;

import java.util.*;

/**
 * 위장(Camouflage)
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.<br>
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *
 * @restrictions
 * 1. clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.<br>
 * 2. 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.<br>
 * 3. 같은 이름을 가진 의상은 존재하지 않습니다.<br>
 * 4. clothes의 모든 원소는 문자열로 이루어져 있습니다.<br>
 * 5. 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.<br>
 * 6. 스파이는 하루에 최소 한 개의 의상은 입습니다.
 *
 * @see
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42578">위장</a>
 * <a href="https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java">문제풀이</a>
 */
public class Camouflage {

    public static String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    public static String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

    public static void main(String[] args) {
        // 의상 종류 별 분류
        Map<String, Integer> hm = new HashMap<>();
        for (String[] strs : clothes2) {
            System.out.println("Each item: " + Arrays.toString(strs));
            System.out.println("Type of clothe: " + strs[1]);
            System.out.println("Count: " + (hm.getOrDefault(strs[1], 0) + 1));

            hm.put(strs[1], hm.getOrDefault(strs[1], 0) + 1);
        }

        // 의상 종류 별 갯수 확인
        System.out.println();
        System.out.println("Each Item count: " + hm.entrySet());
        System.out.println();

        // 각 의상 별 입지 않은 경우를 추가해서 계산
        Iterator<Integer> iter = hm.values().iterator();
        int cases = 1;
        while(iter.hasNext()) {
            cases *= iter.next().intValue() + 1;
        }

        // 아무종류도 입지 않았을 경우의 수 빼기
        cases -= 1;
        System.out.println("======== ANSWER ========");
        System.out.println("CASES: " + cases);


//        for (int i = 0; i < clothes1.length; i++) {
//            String[] inStr = clothes1[i];
//            for (int j = 0; j < inStr.length; j++) {
//                System.out.println(inStr[j]);
//            }
//        }
//        System.out.println(solution(clothes1));
//        System.out.println(solution(clothes2));
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> total = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            total.put(clothes[i][1],total.getOrDefault(clothes[i][1],1)+1);
            System.out.println(clothes[i][1] + " / " + total.getOrDefault(clothes[i][1], 1)+1);
        }
        Collection<Integer> test = total.values();
        answer = test.stream().reduce(1, (a, b) -> a*b) - 1;
        return answer;
    }


}
