package study.modernjava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExam1 {
	private static List<Student> list = Arrays.asList(
				new Student("Jackie", 90, 65),
				new Student("Jolie", 100, 100)
			);
	
	public static void printString(Function<Student, String> function) {
		for (Student student : list) {
			System.out.println(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.println(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Namse : ");
		printString(t -> t.getName());
		
		System.out.println("English Socres : ");
		printInt(Student::getEnglishScore);
		
		System.out.println("Math Socres : ");
		printInt(Student::getMathScore);
	}
	
	
}
