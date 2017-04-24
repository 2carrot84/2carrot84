package helloworld;

public class Fibonacci {
	public long fibonacci(int num) {
		if(num <= 1) return num;
		return this.fibonacci(num-1) + this.fibonacci(num-2);
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Fibonacci c = new Fibonacci();
		System.out.println(c.fibonacci(3));
		System.out.println(c.fibonacci(4));
		System.out.println(c.fibonacci(5));
		System.out.println(c.fibonacci(6));
		System.out.println(c.fibonacci(7));
	}
}