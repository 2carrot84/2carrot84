package codility.timecomplexity;

import java.util.stream.IntStream;

public class TapeEquilibrium {
	
	public static void main(String[] args) {
		TapeEquilibrium t = new TapeEquilibrium();
		
		System.out.println(t.solution(new int[] {8,7,10,2,1,3,5,4,6}));
	}
	// https://codility.com/demo/results/training4SEPPU-Y3W/
	public int solution(int[] A) {
        // write your code in Java SE 8
		int leftSum = 0;
		int rightSum = IntStream.of(A).sum();
		int min = Integer.MAX_VALUE;
		int tmp = rightSum - leftSum;
		
		for (int i = 0; i < A.length-1; i++) {
			leftSum += A[i];
			rightSum -= A[i];
			tmp = Math.abs(rightSum - leftSum);
			if(min > tmp) min = tmp;
		}
		
		return min;
    }
}
