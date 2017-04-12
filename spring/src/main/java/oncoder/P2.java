package oncoder;

import java.util.HashMap;
import java.util.Map;

public class P2 {
	/*
	 * 1. string ���� char �� �Ǽ��� map���� �����.
	 * 2. n �� ���� �Ǽ��� ���� char�� map���� �����Ѵ�.
	 * 3. map ���� cnt�� max, min ���� ���� - �Ѵ�.
	 */
	private HashMap<Character, Integer> hm;

	public int solution(String s, int n) {
		if(s.length() < 1 || 50 < s.length()) {
			System.err.println("�Է� ���ڰ� �߸��Ǿ����ϴ�.");
			return -1;
		}

		if(n < 0 || s.length()-1 < n) {
			System.err.println("���� ���ڼ��� �߸��Ǿ����ϴ�.");
			return -1;
		}

		hm = this.makeHashMap(s);
		hm = this.removeChar(hm, n);

		return this.getResult(hm);
	}

	// string ���� char �� �Ǽ��� map���� �����.
	private HashMap<Character, Integer> makeHashMap(String str) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if(hm.containsKey(c)) {	// map �� �ش� ���ڿ��� ������ ���
				hm.replace(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}
		}
		return hm;
	}

	// n �� ���� �Ǽ��� ���� char�� map���� �����Ѵ�.
	private HashMap<Character, Integer> removeChar(HashMap<Character, Integer> hm, int n) {
		Map<Character, Integer> map = new HashMap<Character, Integer>(hm);
		// java.util.ConcurrentModificationException �ذ��� ���� �ӽ� hashMap ���
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int cnt = entry.getValue();

			if(cnt <= n) {
				hm.remove(key);
			}
		}

		return hm;
	}

	// map ���� cnt�� max, min ���� ���� - �Ѵ�.
	private int getResult(HashMap<Character, Integer> hm) {
		if(hm == null) {
			return 0;
		}
		
		int max = -1;
		int min = -1;
		
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			int cnt = entry.getValue();
			// ���� ����� max, min �ʱⰪ
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
