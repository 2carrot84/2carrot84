package helloworld;

import org.junit.Assert;
import org.junit.Test;

public class GetMinSum {
	@Test
	public void getMinSumTest() {
		GetMinSum test = new GetMinSum();

		int []A = {1,2};
		int []B = {3,4};
		Assert.assertEquals(test.getMinSum(A, B), 10);
	}
	
	public int getMinSum(int[] A, int[] B) {
		
		int answer = 0;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				System.out.println("A["+i+"]*B["+j+"] : " + A[i]*B[j]);
			}
		}

		return answer;
	}
	
	public int test(int[] a, int[] b, int indexA, int indexB) {
		if(a.length == indexA && b.length == indexB) return a[indexA] * b[indexB];
		
		int min = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(i == indexA || j == indexB) {
					continue;
				}
				
				if(min > (a[i]*b[j])) {
					min = a[i]*b[j];
				}
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		GetMinSum test = new GetMinSum();
		int []A = {1,2,5};
		int []B = {3,4,7};
		System.out.println(test.getMinSum(A,B));
	}
}