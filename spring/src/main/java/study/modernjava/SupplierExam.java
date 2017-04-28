package study.modernjava;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExam {
	public static void main(String[] args) {
		// Supplier 파라미터 x, 리턴값 o
		IntSupplier intSupplier = () -> {
			int num = (int)(Math.random() * 6) + 1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수 : " + num);
		
		Supplier<String> supplier = () -> {
			String[] words = {"Hello", "Hi", "Bye", "Good Bye"};
			return words[(int)(Math.random()*4)];
		};
		
		for (int i = 0; i < 5; i++) {
			System.out.println(supplier.get());
		}
	}
}
