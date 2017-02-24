package codility.lesson1;

public class Iterations {
	public static void main(String args[]) {
		int N = 561892;
		System.out.println("N : " + N + ", zero length : " + Iterations.solution(N));
	}

	static public int solution(int N) {
		int zeroLength = 0;
		String strBinary = "";

		if(N < 0) {
			return zeroLength;
		}

		try {
			strBinary = Integer.toString(N, 2);
			int startIndex = 0;

			/**
			 * 1. 0 발견시 startIndex 입력
			 * 2. startindex가 0이 아니고 charAt이 1인경우 현재 zeroLength와 (index - startIndex) 비교 하여 클경우 zeroLength에 값 할당
			 * 3. startIndex 0으로 초기화
			 */
			for(int i=0; i< strBinary.length(); i++) {
				if(startIndex == 0 && strBinary.charAt(i) == '0') {
					startIndex = i;
				}
				else if(startIndex != 0 && strBinary.charAt(i) == '1') {
					if(zeroLength < (i-startIndex)) {
						zeroLength = (i-startIndex);
					}
					startIndex = 0;
				}
			}
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return zeroLength;
	}
}
