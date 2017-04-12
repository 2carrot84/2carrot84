package oncoder;


public class P1 {
	public int solution(int[] seq) {
		// 단조수열 길이
		int sequenceLength = 1;
		// 증가(0)/감소(1) 구분값
		boolean isAes = false;
		// 최고 길이
		int maxLength = 1;
		
		if(seq.length < 1 || 50 < seq.length ) {
			System.err.println("요소의 갯수가 잘못되었습니다.");
			return -1;
		}
		
		for (int i = 0; i < seq.length-1; i++) {
			if(seq[i] < 1 || 100 < seq[i]) {
				System.err.println("요소의 값의 범위가 잘못되었습니다.");
				return -1;
			}
			
			// 배열시작시 또는 값이 같을경우 증가/감소 구분값 설정
			if(i == 0 || sequenceLength == 1) {
				if(seq[i] < seq[i+1]) {
					isAes = true;	// 오름차순
				}
				else if(seq[i] > seq[i+1]){
					isAes = false;	// 내림차순
				}
			}

			if(isAes) {	// 오름차순일 경우
				if(seq[i] < seq[i+1]) {	// 다음 배열 값이 크면 count 증가
					isAes = true;
					sequenceLength++;
					maxLength = this.diffMax(maxLength, sequenceLength);	// 최고 길이 구하기
				}
				else if(seq[i] > seq[i+1]) {	// 다음 배열 값이 작으면 count 증가
					isAes = false;
					sequenceLength = 2;
				}
				else {	// 다음 배열 값이 같으면 count 초기화
					isAes = false;
					sequenceLength = 1;
				}
			}
			else if(!isAes) {	// 내림차순일 경우
				if(seq[i] > seq[i+1]) {	// 다음 배열 값이 작으면 count 증가
					isAes = false;
					sequenceLength++;
					maxLength = this.diffMax(maxLength, sequenceLength);	// 최고 길이 구하기
				}
				else if(seq[i] < seq[i+1]) {	// 다음 배열 값이 크면 count 증가
					isAes = true;
					sequenceLength = 2;
				}
				else {	// 다음 배열 값이 크거나 같으면 count 초기화
					isAes = true;
					sequenceLength = 1;
				}
			}
		}
		return maxLength;
	}
	
	private int diffMax(int a, int b) {
		return a<b?b:a;
	}
	
	public static void main(String[] args) {
		P1 p = new P1();
    	
    	int[] s1 = {1,7,7,8,3,6,7,2};
    	System.out.println("단조수열 길이는 " + p.solution(s1));
	}

}
