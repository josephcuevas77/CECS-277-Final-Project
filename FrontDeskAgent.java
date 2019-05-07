package FinalExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Master class/Employee that has control over all rooms, guest info, and reservations
 *
 */
public class FrontDeskAgent {
	
	private Scanner in = new Scanner(System.in);
	
	private ArrayList<Guest> guests = new ArrayList<Guest>();
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private ArrayList<Reservation> waitlist = new ArrayList<Reservation>();

	/**
	 * Views if room is available at the time requested
	 * @return boolean of true if room is free and false if otherwise
	 */
	public boolean viewAvailability(Guest guest) {
		System.out.print("\nEnter the Date of Reservation: MM/DD/YYYY: ");
		String[] stringDate = in.nextLine().split("/");
		int[] date = new int[stringDate.length];
		for(int i = 0; i < stringDate.length; i++) date[i] = Integer.parseInt(stringDate[i]);
		guest.setDate(new Date(date[0], date[1], date[2]));
		
		for(Reservation i: reservations) {
			return(guest.getDate().equals(i.getDate()));
		}
	}
	
	/**
	 * Adds reservation to waitlist if full
	 * @param r - reservation to be added
	 */
	public void addToWaitlist(Reservation r) {
		waitlist.add(r);
	}
	
	/**
	 * Removes reservation from waitlist
	 * @param r - reservation
	 */
	public void removeFromWaitlist(Reservation r) {
		waitlist.remove(r);
	}
	
	/**
	 * updates the guest info
	 * @param g - guest
	 */
	public void updateGuestInfo(Guest g) {
		Scanner in = new Scanner(System.in);
		if (choice == 1){
			g.setName(in.next);
		}
	}
	
	/**
	 * checks if a room is reserved
	 * @param d - date of reservation
	 * @return true if reserved and false otherwise
	 */
	public boolean isReserved(Date d) {
		for (Reservation r : getReservations()) {
			if (r.getDate() == d) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Collects money from customer
	 */
	public void collectAmountDue() {
		
	}
	
	/**
	 * edits the info of guest
	 */
	public void editGuestInfo() {
		
	}
	
	
	public static void main(String[] args) {

	}

	/**
	 * Gets the list of reservations
	 * @return
	 */
	public static ArrayList<Reservation> getReservations() {
		return reservations;
	}

}
