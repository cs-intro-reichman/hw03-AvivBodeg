/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		int lastYear =  2001;//Integer.parseInt(args[0]);

		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (true) {
	 		//// Write the body of the while
			if ( dayOfWeek == 1){
				System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
			} else {
				System.out.println(dayOfMonth + "/" + month + "/" + year);
			}
	 		advance();
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		if (year == lastYear + 1) {
	 			break;
	 		}
        }
	 	//// Write the necessary ending code here
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		 dayOfWeek = (dayOfWeek == 7) ? 1 : dayOfWeek + 1;
		 if (dayOfMonth == nDaysInMonth()){
			 dayOfMonth = 1;
			 month = (month == 12) ? 1: month + 1;
		 } else {
			 dayOfMonth++;
		 }
		 if (dayOfMonth == 1 && month == 1){
			 year++;
		 }
	 }
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		return (year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0);
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth() {
		if (month == 2) {
			return isLeapYear(year) ? 29 : 28;
		} else if ((month < 8 && month % 2 == 1) || (month > 7 && month % 2 == 0)) {
			return 31;
		} else {
			return 30;
		}
	}
}
