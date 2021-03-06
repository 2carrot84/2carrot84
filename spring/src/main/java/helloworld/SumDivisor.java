package helloworld;

import java.util.stream.IntStream;

public class SumDivisor {
	public int sumDivisor(int num) {
		int answer = 0;
		
		for (int i = 1; i <= num; i++) {
			if(num%i == 0) answer += i;
		}

		return IntStream.rangeClosed(1,num).filter(x -> num % x == 0).sum();
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		SumDivisor c = new SumDivisor();
		System.out.println(c.sumDivisor(12));
	}
}
