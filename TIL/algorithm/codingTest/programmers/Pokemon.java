package codingTest.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 포켓몬
 * 최대 선택 가능한 마리수: N/2
 * 중복된 종류의 포켓몬은 선택 가능한 숫자를 1마리로 간주
 *
 * @restrictions
 * 1. nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
 * 2. nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
 * 3. 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
 * 4. 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1845">포켓몬</a>
 */
public class Pokemon {

//    static int[] nums = {1,2,3,4,5,6};
//    static int[] nums = {1,2,2,4,5,6};
//    static int[] nums = {1,3,3,3,3,6};
    static int[] nums = {3,3,3,2,2,2};

    public static void main(String[] args) {
        int result = maxPokemon(nums);
        System.out.println("Maximum selectable pokemon number: " + result);
    }

    static int maxPokemon(int[] nums) {
        System.out.println("nums: " + Arrays.toString(nums));
        int maxNumber = nums.length / 2;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n : nums) {
            hm.put(n, n);
        }
        System.out.println("Filtered pokemon entrySet: " + hm.entrySet());

        if(maxNumber < hm.size()) {
            return maxNumber;
        }
        return hm.size();
    }
}
