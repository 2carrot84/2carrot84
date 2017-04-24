package study;

import java.util.stream.IntStream;

public class IntstreamTest {
	static int sum = 0;
	
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 10);
		stream.forEach(i -> System.out.println(i));

		stream = IntStream.rangeClosed(1, 5);
		stream.forEach(System.out::println);

		stream = IntStream.rangeClosed(1, 5);
		stream.forEach(i -> sum += i);
		System.out.println("sum : " + sum);
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("sum2 : " + IntStream.of(arr).sum());
		System.out.println("sum3 : " + IntStream.of(arr).filter(i -> i%2==1).sum());
	}
}
