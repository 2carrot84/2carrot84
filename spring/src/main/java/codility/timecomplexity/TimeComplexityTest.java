package codility.timecomplexity;

import org.junit.Assert;
import org.junit.Test;


public class TimeComplexityTest {
	
	@Test
	public void permMissingElemTest() {
		PermMissingElem p = new PermMissingElem();
		
		Assert.assertEquals(p.solution(new int[] {2,3,1,5}), 4);
		Assert.assertEquals(p.solution(new int[] {2,1,5,4,6}), 3);
		Assert.assertEquals(p.solution(new int[] {8,7,10,2,1,3,5,4,6}), 9);
	}
	
	@Test
	public void frogJump() {
		FrogJump j = new FrogJump();
		
		Assert.assertEquals(j.solution(10, 85, 30), 3);
		Assert.assertEquals(j.solution(10, 40, 30), 1);
	}
}
