package helloworld;

import java.util.Calendar;
import java.util.Locale;

public class GetDayName {
	public String getDayName(int month, int day) {
        
		Calendar cal = Calendar.getInstance() ;
        cal.set(2016, month-1, day);
        
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
//		Calendar cal = new Calendar.Builder()
//				.setCalendarType("iso8601").setDate(2016, month-1, day).build();
//
//		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
	}
	
	public static void main(String[] args) {
		GetDayName test = new GetDayName();
		int a=5, b=24;
		System.out.println(test.getDayName(a,b));
	}
}
