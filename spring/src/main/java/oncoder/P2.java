package oncoder;

import java.util.HashMap;
import java.util.Map;

public class P2 {
	/*
	 * 1. string 값을 char 별 건수를 map으로 만든다.
	 * 2. n 값 보다 건수가 납은 char는 map에서 삭제한다.
	 * 3. map 에서 cnt가 max, min 값을 구해 - 한다.
	 */
	private HashMap<Character, Integer> hm;

	public int solution(String s, int n) {
		if(s.length() < 1 || 50 < s.length()) {
			System.err.println("입력 문자가 잘못되었습니다.");
			return -1;
		}

		if(n < 0 || s.length()-1 < n) {
			System.err.println("삭제 문자수가 잘못되었습니다.");
			return -1;
		}

		hm = this.makeHashMap(s);
		hm = this.removeChar(hm, n);

		return this.getResult(hm);
	}

	// string 값을 char 별 건수를 map으로 만든다.
	private HashMap<Character, Integer> makeHashMap(String str) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if(hm.containsKey(c)) {	// map 상에 해당 문자열이 존대할 경우
				hm.replace(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}
		}
		return hm;
	}

	// n 값 보다 건수가 납은 char는 map에서 삭제한다.
	private HashMap<Character, Integer> removeChar(HashMap<Character, Integer> hm, int n) {
		Map<Character, Integer> map = new HashMap<Character, Integer>(hm);
		// java.util.ConcurrentModificationException 해결을 위해 임시 hashMap 사용
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int cnt = entry.getValue();

			if(cnt <= n) {
				hm.remove(key);
			}
		}

		return hm;
	}

	// map 에서 cnt가 max, min 값을 구해 - 한다.
	private int getResult(HashMap<Character, Integer> hm) {
		if(hm == null) {
			return 0;
		}
		
		int max = -1;
		int min = -1;
		
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			int cnt = entry.getValue();
			// 최초 실행시 max, min 초기값
			if(max == -1 && min == -1) {	 
				max = cnt;
				min = cnt;
			}

			if(max < cnt) {
				max = cnt;
			}

			if(cnt < min) {
				min = cnt;
			}
		}

		return (max - min);
	}

	public static void main(String[] args) {
		P2 p = new P2();

		String s1 = "dddddcccssffaabkdjfkd";
		System.out.println(p.solution(s1,2));
	}
}
