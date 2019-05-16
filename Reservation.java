package FinalExam;

import java.util.ArrayList;

/**
 * Creates reservation objects to be checked by employee
 *
 */
public class Reservation {
	public static String[] roomOptions = {"Small Party Room"," Medium Party Room", "Karaoke Lounge", "Adults Billiards Lounge", "Aqua World"};
	private BaseRoom baseRoom;
	private Date date;
	private Guest guest;
	private boolean isFinalized;
	private int confirmNum;
	
	/**
	 * Default constructor for Reservation
	 */
	public Reservation() {
		baseRoom = null;
		date = new Date();
		guest = new Guest();
		isFinalized = false;
		confirmNum = 0;
	}
	
	/**
	 * Overloaded Constructor
	 * @param BaseRoom - base room
	 * @param date - date of reservation
	 * @param guest - info of guest
	 * @param isF - checks if reservation is finalized
	 */
	public Reservation(BaseRoom BaseRoom,Date date, Guest guest, boolean isF, int cNum) {
		this.baseRoom = BaseRoom;
		this.date = date;
		this.guest = guest;
		this.isFinalized = isF;
		this.confirmNum = cNum;
	}
	
	/**
	 * gets base room
	 * @return base room
	 */
	public BaseRoom getBaseRoom() {
		return baseRoom;
	}

	/**
	 * sets base room
	 * @param BaseRoom to be set
	 */
	public void setBaseRoom(BaseRoom BaseRoom) {
		this.baseRoom = BaseRoom;
	}

	/**
	 * gets date of reservation
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	
	

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	/**
	 * sets date of reservation
	 * @param date of reservation
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getConfirmNum() {
		return confirmNum;
	}

	public void setConfirmNum(int confirmNum) {
		this.confirmNum = confirmNum;
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
		String reserve = "Reservation:\nRoom: " + baseRoom + "\nDate: " + date + "\n" + guest + "Finalized?: " + isFinalized + "\n";
		return reserve;
	}
}