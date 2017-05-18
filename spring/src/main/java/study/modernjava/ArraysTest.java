package study.modernjava;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysTest {
	public static void main(String[] args) {
		int [] a = new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		// filter out all indices that evenly divide 3
		System.out.println(IntStream.range(0, 3).map(i -> a[i]).sum());
	}
}
