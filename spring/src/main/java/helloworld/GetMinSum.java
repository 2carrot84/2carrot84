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
		
		int[] c = {8830, 5844, 8239, 777, 2961, 2422, 9397, 1302, 6107, 2860};
		int[] d = {2349, 1764, 150, 5746, 4056, 5495, 7960, 2608, 7291, 5514};
		Assert.assertEquals(test.getMinSum(c, d), 137604750);
	}
	
	public int getMinSum(int[] A, int[] B) {
		int[][] temp = new int[A.length][B.length];
		int answer = 0;
		
		System.out.println(A.length + ", " + B.length);
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = A[i]*B[j];
				System.out.println("temp["+i+"]["+j+"] : " + temp[i][j]);
				System.out.println("A["+i+"] : " + A[i]);
				System.out.println("B["+j+"] : " + B[j]);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		GetMinSum test = new GetMinSum();
		int []A = {1,2,5};
		int []B = {3,4,7};
		
		System.out.println(test.getMinSum(A,B));
	}
}