package FinalExam;

import java.util.ArrayList;

/**
 * Creates reservation objects to be checked by employee
 *
 */
public class Reservation {
	public static String[] roomOptions = {"Small Party Room"," Medium Party Room", "Karaoke Lounge", "Adults Billiards Lounge", "Aqua World"};
	private BaseRoom BaseRoom;
	private Date date;
	private Guest guest;
	private boolean isFinalized;
	
	/**
	 * Default constructor for Reservation
	 */
	public Reservation() {
		BaseRoom = new BaseRoom(roomOptions[0]);
		date = new Date();
		guest = new Guest();
		isFinalized = false;
	}
	
	/**
	 * Overloaded Constructor
	 * @param BaseRoom - base room
	 * @param date - date of reservation
	 * @param guest - info of guest
	 * @param isF - checks if reservation is finalized
	 */
	public Reservation(BaseRoom BaseRoom,Date date, Guest guest, boolean isF) {
		this.BaseRoom = BaseRoom;
		this.date = date;
		this.guest = guest;
		this.isFinalized = isF;
	}
	
	/**
	 * gets base room
	 * @return base room
	 */
	public BaseRoom getBaseRoom() {
		return BaseRoom;
	}

	/**
	 * sets base room
	 * @param BaseRoom to be set
	 */
	public void setBaseRoom(BaseRoom BaseRoom) {
		this.BaseRoom = BaseRoom;
	}

	/**
	 * gets date of reservation
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * sets date of reservation
	 * @param date of reservation
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * finalizes the reservation and adds to arraylist
	 * @param r - reservation
	 */
	public void finalizeReservation(Reservation r) {
		FrontDeskAgent.getReservations().add(r);
	}
	
	/**
	 * Allows the reservation to be printed out as a String
	 */
	public String toString() {
		String reserve = "Reservation:\nRoom: " + BaseRoom + "\nDate: " + date + "\n" + guest + "Finalized?: " + isFinalized + "\n";
		return reserve;
	}
	
	/**
	 * Tester
	 * @param args
	 */
	public static void main(String[] args) {
		BaseRoom BaseRoom = new BaseRoom();
		Date date = new Date(5,7,2019);
		Guest guest1 = new Guest("Joseph Cuevas", "(714) 714-7147", "joseph@gmail.com", "AMEX 0000 XXXX", date, "12:00", "Deluxe Meal Plan", "extraInfo" );
		System.out.println(new Reservation());
		Reservation r = new Reservation(BaseRoom,date,guest1,true);
		System.out.println(r);
	}
}
