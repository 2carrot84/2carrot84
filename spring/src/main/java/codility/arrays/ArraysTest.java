package codility.arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArraysTest {
	@Test
	public void oddOccurrencesInArrayTest() {
		OddOccurrencesInArray o = new OddOccurrencesInArray();
		int[] A = {9,9,9};
		Assert.assertEquals(o.solution(A), 9);
		int[] B = {3,4,5,9,9};
		Assert.assertEquals(o.solution(B), 3);
		int[] C = {9,3,9,3,9,7,9};
		Assert.assertEquals(o.solution(C), 7);
	}
	
	@Test
	public void cyclicRotation() {
		CyclicRotation c = new CyclicRotation();
		int[] A = {3, 8, 9, 7, 6};
		
		Assert.assertArrayEquals(c.solution(A, 1), new int[] {6, 3, 8, 9, 7});
		Assert.assertArrayEquals(c.solution(A, 4), new int[] {8, 9, 7, 6, 3});
		Assert.assertArrayEquals(c.solution(A, 6), new int[] {6, 3, 8, 9, 7});
	}
}
