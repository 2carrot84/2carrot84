package oncoder;

import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 154910 on 2017-02-02.
 */
public class OncoderTest {
    @Test
    public void test1() {
    	P1 p = new P1();
    	
    	int[] s1 = {1,7,7,8,3,6,7,2};
    	Assert.assertThat(p.solution(s1), is(3));
    	
    	int[] s2 = {1,1,1,1,1};
    	Assert.assertThat(p.solution(s2), is(1));
    	
    	int[] s3 = {10,20,30,25,20,19,20,18,23};
    	Assert.assertThat(p.solution(s3), is(4));
    	
    	int[] s4 = {1};
    	Assert.assertThat(p.solution(s4), is(1));
    	
    	int[] s5 = {100};
    	Assert.assertThat(p.solution(s5), is(1));
    	
    	int[] s6 = {8,2,3,200,3,6,2,3,5,6,0};
    	Assert.assertThat(p.solution(s6), is(-1));
    	
    	int[] s7 = {};
    	Assert.assertThat(p.solution(s7), is(-1));
    }
    
    @Test
    public void test2() {
    	P2 p = new P2();
    	
    	String s1 = "aaaaabbc";
    	Assert.assertThat(p.solution(s1,1), is(3));
    	
    	String s2 = "aaaabbbbc";
    	Assert.assertThat(p.solution(s2,5), is(0));
    	
    	String s3 = "dddddcccssffaabkdjfkd";
    	Assert.assertThat(p.solution(s3,2), is(4));
    	
    	String s4 = "abcd";
    	Assert.assertThat(p.solution(s4,4), is(-1));
    	
    	Assert.assertThat(p.solution(s4,-1), is(-1));
    	
    	String s5 = "";
    	Assert.assertThat(p.solution(s5,3), is(-1));
    	
    	String s6 = "asdfasfasfdasdfasdfasfasdfasdjasldkfjask;lfjasldk;fjaskldfjadsk;lfjad;lsfjaskldfjadsklfjaskldfjf";
    	Assert.assertThat(p.solution(s6,3), is(-1));
    }
}
