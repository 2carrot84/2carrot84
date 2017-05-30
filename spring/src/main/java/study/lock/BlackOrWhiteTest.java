package study.lock;

public class BlackOrWhiteTest {
	public static void main(String[] args) {
		final BlackOrWhite bow = new BlackOrWhite();
		
		Thread white = new Thread() {
			public void run() {
				bow.white();
			}
		};
		
		Thread black = new Thread() {
			public void run() {
				bow.black();
			}
		};
		
		white.start();
		black.start();
	}
}
