package FinalExam;

public class Guest {
	private String name;
	private String phoneNumber;
	private String email;
	private String creditCardInfo;
	private Date date;
	private String time;
	private String mealPlanInfo;
	private String extraInfo;
	
	public Guest() {
		name = "N/A";
		phoneNumber = "N/A";
		email = "N/A";
		creditCardInfo = "N/A";
		date = new Date();
		time = "N/A";
		mealPlanInfo = "N/A";
		extraInfo = "N/A";
	}
	
	public Guest(String name, String pN, String email,String CCI,Date date, String time, String MPI, String EI) {
		this.name = name;
		this.phoneNumber = pN;
		this.email = email;
		this.creditCardInfo = CCI;
		this.date = date;
		this.time = time;
		this.mealPlanInfo = MPI;
		this.extraInfo = EI;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCreditCardInfo() {
		return creditCardInfo;
	}
	
	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getMealPlanInfo() {
		return mealPlanInfo;
	}
	
	public void setMealPlanInfo(String mealPlanInfo) {
		this.mealPlanInfo = mealPlanInfo;
	}
	
	public String getExtraInfo() {
		return extraInfo;
	}
	
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String toString() {
		return "Guest: \nName: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nCredit Card Info: "
				+ creditCardInfo + "\nDate: " + date + "\nTime: " + time + "\nMeal Plan Info: " + mealPlanInfo
				+ "\nExtra Info: " + extraInfo + "\n";
	}	
	
	public static void main(String[] args) {
		Date date = new Date(6,1,1999);
		Guest guest = new Guest();
		Guest guest1 = new Guest("Joseph Cuevas", "(714) 714-7147", "joseph@gmail.com", "AMEX 0000 XXXX", date, "12:00", "Deluxe Meal Plan", "extraInfo" );
		System.out.println(guest);
		System.out.println(guest1);
	}
}
