package codility.etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P2 {
	public static void main(String[] args) {
		System.out.println(P2.solution("10:00", "13:21"));
	}
	
	public static int solution(String E, String L) {
		int ENTRANCE_FEE = 2;
		int FIRST_HOUR_FEE = 3;
		int AFTER_FIRST_FEE = 4;
		
		int totalFee = 0;
		
		String entranceTime = "2017-02-27 " + E + ":00";
		String exitTime = "2017-02-27 " + L + ":00";
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date entranceDate = sf.parse(entranceTime);
			Date exitDate = sf.parse(exitTime);
			
			long timeGap = exitDate.getTime() - entranceDate.getTime();
			timeGap = (timeGap/60000);

			if(timeGap > 0 ) {
				totalFee += ENTRANCE_FEE;
				totalFee += FIRST_HOUR_FEE;
			}
			
			totalFee += ((timeGap/60)-1)*AFTER_FIRST_FEE;
			
			System.out.println(totalFee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		return 0;
	}
}
