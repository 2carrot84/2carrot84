package codility.etc;

public class P2 {
	public static void main(String[] args) {
		System.out.println(P2.solution("09:42", "11:42"));
	}

	public static int solution(String E, String L) {
		int ENTRANCE_FEE = 2;
		int FIRST_HOUR_FEE = 3;
		int AFTER_FIRST_FEE = 4;

		int totalFee = 0;

		String[] arrTmp = E.split(":");
		if(Integer.parseInt(arrTmp[0]) < 0 || Integer.parseInt(arrTmp[0]) >= 24) {
			return 0;
		}
		else if(Integer.parseInt(arrTmp[1]) < 0 || Integer.parseInt(arrTmp[1]) >= 60) {
			return 0;
		}

		int entranceTime = Integer.parseInt(arrTmp[0]) * 60 + Integer.parseInt(arrTmp[1]);  

		arrTmp = L.split(":");
		if(Integer.parseInt(arrTmp[0]) < 0 || Integer.parseInt(arrTmp[0]) >= 24) {
			return 0;
		}
		else if(Integer.parseInt(arrTmp[1]) < 0 || Integer.parseInt(arrTmp[1]) >= 60) {
			return 0;
		}

		int exitTime = Integer.parseInt(arrTmp[0]) * 60 + Integer.parseInt(arrTmp[1]);  

		System.out.println("entranceTime : " + entranceTime);
		System.out.println("exitTime : " + exitTime);

		int timeGap = exitTime - entranceTime;

		if(timeGap > 0) {
			totalFee += ENTRANCE_FEE;
			totalFee += FIRST_HOUR_FEE;
		}
		
		totalFee += ((timeGap/60)-1)*AFTER_FIRST_FEE;

		//		String entranceTime = "2017-02-27 " + E + ":00";
		//		String exitTime = "2017-02-27 " + L + ":00";
		//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//		try {
		//			Date entranceDate = sf.parse(entranceTime);
		//			Date exitDate = sf.parse(exitTime);
		//			
		//			long timeGap = exitDate.getTime() - entranceDate.getTime();
		//			timeGap = (timeGap/60000);
		//
		//			if(timeGap > 0 ) {
		//				totalFee += ENTRANCE_FEE;
		//				totalFee += FIRST_HOUR_FEE;
		//			}
		//			
		//			totalFee += ((timeGap/60)-1)*AFTER_FIRST_FEE;
		//			
		//			System.out.println(totalFee);
		//		} catch (ParseException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}



		return totalFee;
	}
}
