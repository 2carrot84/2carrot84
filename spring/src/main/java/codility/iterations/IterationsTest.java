package codility.iterations;

import org.junit.Assert;
import org.junit.Test;

public class IterationsTest {
	@Test
	public void iteration() {
		Assert.assertEquals(Iterations.solution(9), 2);
		Assert.assertEquals(Iterations.solution(529), 4);
		Assert.assertEquals(Iterations.solution(20), 1);
		Assert.assertEquals(Iterations.solution(15), 0);
		Assert.assertEquals(Iterations.solution(1041), 5);
	}
	
}
