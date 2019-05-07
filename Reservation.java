package FinalExam;

public class Reservation {
	private Date date;
	private Guest guest;
	private boolean isFinalized;
	
	public Reservation() {
		date = new Date();
		guest = new Guest();
		isFinalized = false;
	}
	
	public Reservation(Date date, Guest guest, boolean isF) {
		this.date = date;
		this.guest = guest;
		this.isFinalized = isF;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void finalizeReservation(Reservation r) {
		
	}
	
	public String toString() {
		String reserve = "Reservation:\nDate: " + date + "\n" + guest + "Finalized?: " + isFinalized + "\n";
		return reserve;
	}
	
	public static void main(String[] args) {
		Date date = new Date(5,7,2019);
		Guest guest1 = new Guest("Joseph Cuevas", "(714) 714-7147", "joseph@gmail.com", "AMEX 0000 XXXX", date, "12:00", "Deluxe Meal Plan", "extraInfo" );
		System.out.println(new Reservation());
		Reservation r = new Reservation(date,guest1,true);
		System.out.println(r);
	}
}
