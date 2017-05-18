package codility.arrays;

import java.util.Arrays;

public class CyclicRotation {
	public static void main(String[] args) {
		CyclicRotation c = new CyclicRotation();
		System.out.println(Arrays.toString(c.solution(new int[] {3, 8, 9, 7, 6}, 1)));
	}

	//	https://codility.com/demo/results/trainingFX3CGN-62F/
	public int[] solution(int[] A, int K) {
		// write your code in Java SE 8
		int[] B = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			B[(i+K)%A.length] = A[i];
		}
		
		return B;
	}
}
