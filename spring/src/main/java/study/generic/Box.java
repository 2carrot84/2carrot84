package study.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box<T> {
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
	public <U> void inspect(U u) {
		System.out.println("T : " + t.getClass().getName());
		System.out.println("U : " + u.getClass().getName());
	}
	
	public static void main(String[] args) {
		Box b = new Box();
		b.add(1234);
		System.out.println(b.get());
		b.inspect("1234");
		
		Box<String> str = new Box<String>();
//		str.add(1234);
//		error String으로 타입이 지정되 다른 타입은 안됨
		str.add(String.valueOf(1234));
		str.add("5678");
		System.out.println(str.get());
		str.inspect(9999);
		
		Map<String, List<String>> map = new HashMap();
	}
}
