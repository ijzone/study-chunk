package codingTest.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 완주하지 못한 선수
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * @restrictions
 * 1. 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * 2. completion의 길이는 participant의 길이보다 1 작습니다.
 * 3. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 4. 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42576">완주하지 못한 선수</a>
 */
public class UnfinishedRacer {
	static String[] participant = {"a", "b", "c", "d", "e", "b"};
	static String[] completion = {"b", "a", "e", "c", "d"};
	
	public static void main(String[] args) {
//		System.out.println(mapSolution1(participant, completion));
		System.out.println(mapSolution2(participant, completion));
//		System.out.println(listSolution1(participant, completion));
//		System.out.println(listSolution2(participant, completion));
	}
	
	public static String mapSolution1(String[] participant, String[] completion) {
		String rtn = "";
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(String player : participant) hm.put(player, hm.getOrDefault(player, 0));
		System.out.println("[part]" + hm.entrySet());
		for(String player : completion) hm.put(player, hm.get(player) +1);
		System.out.println("[comp] " + hm.entrySet());
		for(String key : hm.keySet()) {
//			System.out.printf("%s = %d\n", key, hm.get(key));
			if(hm.get(key) < 1) {
				rtn = key;
//				System.out.println(hm.get(key));
//				System.out.println(key);
			}
		}
		
		return rtn;
	}

	public static String mapSolution2(String[] participant, String[] completion) {
		String rtn = "";
		Map<String, Integer> hm = new HashMap<>();
		for (String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		}
		System.out.println("participants: " + hm.entrySet());

		for (String player : completion) {
			hm.put(player, hm.get(player) - 1);
		}
		System.out.println("completion: " + hm.entrySet());

		for (String player : hm.keySet()) {
			if(hm.get(player) != 0) {
				rtn = player;
			}
		}

		return rtn;
	}
	
	public static String listSolution1(String[] participant, String[] completion) {
		boolean flag = true;
		for(int i=0; i < participant.length; i++) {
			flag = true;
			for(int j=0; j < completion.length; j++) {
				if(participant[i].equals(completion[j])) {
					flag = false;
					completion[j] = null;
					break;
				}
			}
			if(flag) {
//				System.out.println(participant[i]);
				return participant[i];
			}
		}
		return participant[participant.length-1];
	}
	
	public static String listSolution2(String[] participant, String[] completion) {
		Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
	}
	
}
