package FinalExam;

public class Reservation {
	private Room room;
	private Date date;
	private Guest guest;
	private boolean isFinalized;
	
	public Reservation() {
		room = new Room();
		date = new Date();
		guest = new Guest();
		isFinalized = false;
	}
	
	public Reservation(Room room,Date date, Guest guest, boolean isF) {
		this.room = room;
		this.date = date;
		this.guest = guest;
		this.isFinalized = isF;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
		String reserve = "Reservation:\nRoom: " + room + "\nDate: " + date + "\n" + guest + "Finalized?: " + isFinalized + "\n";
		return reserve;
	}
	
	public static void main(String[] args) {
		Room room = new Room();
		Date date = new Date(5,7,2019);
		Guest guest1 = new Guest("Joseph Cuevas", "(714) 714-7147", "joseph@gmail.com", "AMEX 0000 XXXX", date, "12:00", "Deluxe Meal Plan", "extraInfo" );
		System.out.println(new Reservation());
		Reservation r = new Reservation(room,date,guest1,true);
		System.out.println(r);
	}
}
