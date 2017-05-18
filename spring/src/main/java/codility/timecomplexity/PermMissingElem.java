package codility.timecomplexity;

import java.util.stream.IntStream;

public class PermMissingElem {
	// https://codility.com/demo/results/trainingDGKDQB-KBZ/
	public int solution(int[] A) {
		int sum = IntStream.of(A).sum();		
		int expected = IntStream.rangeClosed(1,A.length+1).sum();		
		return expected-sum;
	};
}
