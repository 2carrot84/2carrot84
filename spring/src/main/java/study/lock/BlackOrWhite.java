package study.lock;

public class BlackOrWhite {
	private String str;
	private final String BLACK = "black";
	private final String WHITE = "white";
	
	public synchronized void black() {
		str = BLACK;
		try {
			long sleep = (long)(Math.random()*100L);
			Thread.sleep(sleep);
			if(!str.equals(BLACK)) {
				System.out.println("+++ broken!! +++");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void white() {
		str = WHITE;
		try {
			long sleep = (long)(Math.random()*100L);
			Thread.sleep(sleep);
			if(!str.equals(WHITE)) {
				System.out.println("+++ broken!! +++");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
