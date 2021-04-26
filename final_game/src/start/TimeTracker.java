package start;

import java.util.Calendar;

/**
 * Time Tracker Class
 */
public class TimeTracker {
	
	static Calendar dateTime = Calendar.getInstance();

	/**
	 * SetTime Method
	 * 
	 * @return
	 */
	public static void setCalendarTime(){
				
		// Set Calendar Time
		dateTime.set(Calendar.YEAR, 2020);
		dateTime.set(Calendar.MONTH, 4);
		dateTime.set(Calendar.DATE, 13);
		dateTime.set(Calendar.HOUR_OF_DAY, 12);
		dateTime.set(Calendar.MINUTE, 00);
		dateTime.set(Calendar.SECOND, 00);
	}
	
	/**
	 * Increase Time By Hours Method
	 * @param amount
	 */
	public static void increaseTimeByHours(int amount) {
		
		dateTime.add(Calendar.HOUR_OF_DAY, amount);
	}
}
