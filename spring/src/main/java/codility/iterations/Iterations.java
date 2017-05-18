package codility.iterations;

public class Iterations {
	public static void main(String args[]) {
		System.out.println(Iterations.solution(9));;
	}
	// https://codility.com/demo/results/trainingYZQ43A-QW9/
	static public int solution(int N) {
		if(N < 0 || Integer.MAX_VALUE < N) {
			System.err.println("input value range error!!");
			return 0;
		}
		
		String str = Integer.toBinaryString(N);
		int maxLength = 0;
		int length = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '1') {
				if(maxLength < length) {
					maxLength = length;
				}
				length = 0;
			}
			else {
				length++;
			}
		}

		return maxLength;
	}
}
