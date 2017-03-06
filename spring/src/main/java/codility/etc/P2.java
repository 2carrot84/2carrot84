package codility.etc;

public class P2 {
	public static void main(String[] args) {
		P2 p = new P2();
		System.out.println(p.solution("10:00", "13:21"));
		System.out.println(p.solution("09:42", "11:45"));
		System.out.println(p.solution("00:10", "00:10"));
	}

	public int solution(String E, String L) {
		int ENTRANCE_FEE = 2;
		int FIRST_HOUR_FEE = 3;
		int AFTER_FIRST_FEE = 4;
		int totalFee = 0;

		if(!validateTimeFormat(E)) {
			return -1;
		}
		else if(!validateTimeFormat(L)) {
			return -1;
		}
		
		String[] arrTmp = E.split(":");
		int entranceTime = Integer.parseInt(arrTmp[0]) * 60 + Integer.parseInt(arrTmp[1]);  
		arrTmp = L.split(":");
		int exitTime = Integer.parseInt(arrTmp[0]) * 60 + Integer.parseInt(arrTmp[1]); 
		
		if(entranceTime > exitTime) {
			return -1;
		}
		
		int timeGap = exitTime - entranceTime;
		
		if(timeGap == 0) {
			return ENTRANCE_FEE;
		}

		if(timeGap > 0) {
			totalFee += ENTRANCE_FEE;
			totalFee += FIRST_HOUR_FEE;
		}
		
		totalFee += ((timeGap/60)-1)*AFTER_FIRST_FEE;

		if((timeGap%60) != 0) {
			totalFee += AFTER_FIRST_FEE;
		}
		
		return totalFee;
	}
	
	public boolean validateTimeFormat(String time) {
		if(time.indexOf(':') < 0) 
			return false;
		
		String[] arrTmp = time.split(":");
		if(Integer.parseInt(arrTmp[0]) < 0 || 24 <= Integer.parseInt(arrTmp[0])) {
			return false;
		}
		else if(Integer.parseInt(arrTmp[1]) < 0 || 60 <= Integer.parseInt(arrTmp[1])) {
			return false;
		}
		
		return true;
	}
}
