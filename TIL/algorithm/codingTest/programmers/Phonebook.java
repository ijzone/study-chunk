package codingTest.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 전화번호 목록
 * @desc 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 *
 * @restrictions
 * 1. phone_book의 길이는 1 이상 1,000,000 이하입니다.<br>
 * 2. 각 전화번호의 길이는 1 이상 20 이하입니다.<br>
 * 3. 같은 전화번호가 중복해서 들어있지 않습니다.
 *
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42577">전화번호 목록</a>
 */
public class Phonebook {
	static String[] phone_book1 = {"119", "97674223", "1195524421"};
	static String[] phone_book2 = {"123","456","789"};
	static String[] phone_book3 = {"12","123","1235","567","88"};
	static String[] phone_book4 = {"12", "123", "1235", "567", "88"};

	public static void main(String[] args) {
		System.out.println(solution1(phone_book1));
	}
	
	public static boolean solution1(String[] phone_book) {
		boolean answer = true;
		
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for(int i = 0; i < phone_book.length; i++) {
			hm.put(phone_book[i], i);
		}

		System.out.println("entrySet(): " + hm.entrySet());
		for(int i = 0; i < phone_book.length; i++) {
			for(int j = 1; j < phone_book[i].length(); j++) {
				if(hm.containsKey(phone_book[i].substring(0, j))) {
					System.out.println("phone_book[i].substring(0, j): " + phone_book[i].substring(0, j));
					answer = false;
					break;
				}
			}
		}
		
		return answer;
	}
	
	public static boolean solution2(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for(int i = 0; i < phone_book.length-1; i++) {
			for(int j = i + 1; j < phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i])) {
					answer = false;
				}
			}
		}
		
		return answer;
	}
}
