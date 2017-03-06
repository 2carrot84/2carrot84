package codility.etc;

import java.util.Arrays;

public class P3 {
	public boolean solution(int[] A) {
		int count = 0;
		int tempA, tempB = 0;
		for (int i = 0; i < A.length-1; i++) {
			if(A[i] > A[i+1]) {
//				System.out.println(A[i] + " > " + A[i+1] + " : " + (A[i] > A[i+1]));
				tempA = A[i];
				tempB = A[i+1];
				for (int j = i+1; j < A.length; j++) {
					if(tempA > A[j] && tempB != A[j]) {
//						System.out.println(tempA + " > " + A[j] + " : " + (tempA > A[j]));
						count++;
					}
				}
			}
		}
		
//		System.out.println("count : " + count);
		
		if(count == 0) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		P3 p = new P3();
		int[]A = {1,2};
        int[]B = {1,3,6,3,5,5,3,7,7};
        int[]C = {1, 4, 5, 6, 7, 2}; 
        int[]D = {1,2,3,4,5,6,7,8,9,10,11,2,45,56,67,78,89,90,123,124,1245566778};
        int[]D1 = {1,2,3,4,5,6,7,8,9,10,11,2,45,56,67,78,89,90,2,123,124,1245566778};
        int[]E = {1, 5, 3, 3, 7} ;
        int[]F= {1, 3, 5};
        int[]G = {1,5,3};
		System.out.println(p.solution(A));
		System.out.println(p.solution(B));
		System.out.println(p.solution(C));
		System.out.println(p.solution(D));
		System.out.println(p.solution(D1));
		System.out.println(p.solution(E));
		System.out.println(p.solution(F));
		System.out.println(p.solution(G));
	}
}
