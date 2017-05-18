package codility.timecomplexity;

public class FrogJump {
	// https://codility.com/demo/results/training934YSW-QYG/
	public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
		int min = (Y-X)/D;
		return (Y-X)%D == 0 ?min:min+1;
    }
}
