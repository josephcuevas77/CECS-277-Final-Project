package FinalExam;

/**
 * Date class that aggregates the Reservation class
 * used to get the day, month and year of the Reservation
 */
public class Date {
	
	/**
	 * instance variables for day, month and year
	 */
	private int day;
	private int month;
	private int year;

	/**
	 * default constructor
	 */
	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
	
	/**
	 * overloaded constructor
	 * @param month
	 * @param day
	 * @param year
	 */
	public Date(int month,int day,int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * gets the day of the reservation
	 * @return day of reservation
	 */
	public int getDay() {
		return day;
	}

	/**
	 * sets the day of the reservation
	 * @param day
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * gets the month of the reservation
	 * @return month of the reservation
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * sets the month of the reservation
	 * @param month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * gets the year of the reservation
	 * @return year of reservation
	 */
	public int getYear() {
		return year;
	}

	/**
	 * sets the year of the reservation
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * toString that returns the date values into a "mm/dd/yyyy" format
	 */
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	/**
	 * checks if the date is available and returns true if the desired date matches
	 * the available date
	 * @param date that is requested
	 * @return boolean if the date is available or not
	 */
	public boolean equals(Date date) { return(this.day == date.day && this.month == date.month && this.year == date.year); }
	
	/**
	 * tester
	 */
	public static void main(String[] args) {
		Date date = new Date();
		Date date1 = new Date(06,01,1999);
		Date date2 = new Date(06,01,1999);
		Date date3 = new Date(05,01,1999);
		System.out.println(date);
		System.out.println(date1);
		System.out.println(date1.equals(date2));
		System.out.println(date1.equals(date3));
	}
}
