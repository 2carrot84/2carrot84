package study.generic;

public class MyBox<X> {
	X x;
	<T> MyBox(T t) {
		this.x = (X)t;
	}

	public static void main(String[] args) {
		MyBox<Integer> obj = new MyBox<>("1234");
	}
}
