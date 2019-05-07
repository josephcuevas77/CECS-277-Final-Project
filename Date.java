package FinalExam;

public class Date {
	
	private int day;
	private int month;
	private int year;

	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
	
	public Date(int day,int month,int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return "Date: " + day + "/" + month + "/" + year + "\n";
	}
	
	public boolean equals(Date date) { return(this.day == date.day && this.month == date.month && this.year == date.year); }
	
	public static void main(String[] args) {
		Date date = new Date();
		Date date1 = new Date(06,01,1999);
		Date date2 = new Date(06,01,1999);
		System.out.println(date);
		System.out.println(date1);
		System.out.println(date1.equals(date2));
		
	}
	

}
