package helloworld;

import java.util.Arrays;

public class TryHelloWorld {
	public int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];
		answer[0] = TryHelloWorld.gcd(a, b);
		answer[1] = TryHelloWorld.lcm(a, b);
		return answer;
	}

	public static int lcm(int a, int b) {
		int gcd_value = gcd(a, b);
		if (gcd_value == 0) return 0;
		return Math.abs( (a * b) / gcd_value );
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		TryHelloWorld c = new TryHelloWorld();
		System.out.println(Arrays.toString(c.gcdlcm(192, 72)));
	}
}
