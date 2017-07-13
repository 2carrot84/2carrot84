package study.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Human {
	public List<String> array = Collections.synchronizedList(new ArrayList<String>()) ;

	public Human() {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (array) {
					for (int i = 0; i < array.size(); i++) {
						System.out.println(array.get(i));
					}
				}
			}
		}.start();
	}
	
	public void add(String str) {
		array.add(str);
	}
	
	public void remove(String str) {
		array.remove(str);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Human h = new Human();
		
		while(true) {
			h.add("aaaa");
			h.add("bbbb");
			
			h.remove("aaaa");
			h.remove("bbbb");
		}
	}
}
