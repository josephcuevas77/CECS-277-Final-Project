package FinalExam;

/**
 * Guest class that aggregates the Reservation class and
 * inherits the GuestDecorator class
 * hold the guests info that is reserving the room
 */
public class Guest {
	
	/**
	 * instance variables
	 */
	private String name;
	private String phoneNumber;
	private String email;
	private String creditCardInfo;
	private Date date;
	private String time;
	private String mealPlanInfo;
	private String extraInfo;
	private boolean isCheckedIn;
	
	/**
	 * default constructor
	 */
	public Guest() {
		name = "N/A";
		phoneNumber = "N/A";
		email = "N/A";
		creditCardInfo = "N/A";
		date = new Date();
		time = "N/A";
		mealPlanInfo = "N/A";
		extraInfo = "N/A";
		isCheckedIn = false;
	}
	
	/**
	 * overloaded constructor
	 * @param name of guest
	 * @param pN phone number of guest
	 * @param email of guest
	 * @param CCI credit card info of guest
	 * @param date the room is planned to be reserved
	 * @param time the room is planned to be reserved
	 * @param MPI meal plan information
	 * @param EI any extra information
	 */
	public Guest(String name, String pN, String email,String CCI,Date date, String MPI, String EI) {
		this.name = name;
		this.phoneNumber = pN;
		this.email = email;
		this.creditCardInfo = CCI;
		this.date = date;
		this.mealPlanInfo = MPI;
		this.extraInfo = EI;
		isCheckedIn = false;
	}
	
	/**
	 * gets the name of the guest
	 * @return name of guest
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of the guest
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gets the phone number of the guest
	 * @return phone number of guest
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * sets the guest phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * gets the email of the guest
	 * @return email of guest
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * sets the guest email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * gets the credit card info of the guest
	 * @return credit card info of guest
	 */
	public String getCreditCardInfo() {
		return creditCardInfo;
	}
	
	/**
	 * sets the credit card info of the guest
	 * @param creditCardInfo
	 */
	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
	
	/**
	 * gets the date the room was reserved
	 * @return date the room was reserved
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * sets the room date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * gets the time the room was reserved
	 * @return time the room was reserved
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * sets the time
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * gets the meal plan info
	 * @return meal plan info
	 */
	public String getMealPlanInfo() {
		return mealPlanInfo;
	}
	
	/**
	 * sets the meal plan info
	 * @param mealPlanInfo
	 */
	public void setMealPlanInfo(String mealPlanInfo) {
		this.mealPlanInfo = mealPlanInfo;
	}
	
	/**
	 * gets any extra info the guest requests
	 * @return extra info
	 */
	public String getExtraInfo() {
		return extraInfo;
	}
	
	/**
	 * sets the extra info added
	 * @param extraInfo
	 */
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	
	public boolean getCheckInStatus() {
		return isCheckedIn;	
	}
	public void setCheckInStates(boolean b) {
		isCheckedIn = b;
	}
	
	/**
	 * toString that formats the guest info
	 * @return the guest info
	 */
	public String toString() {
		return "Guest: \nName: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nCredit Card Info: "
				+ creditCardInfo + "\nDate: " + date + "\nTime: " + time + "\nMeal Plan Info: " + mealPlanInfo
				+ "\nExtra Info: " + extraInfo + "\n";
	}	
	
}
