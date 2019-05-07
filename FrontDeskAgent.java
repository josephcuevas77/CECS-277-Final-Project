package FinalExam;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontDeskAgent {
	
	private ArrayList<Guest> guests = new ArrayList<Guest>();
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private ArrayList<Reservation> waitlist = new ArrayList<Reservation>();

	public boolean viewAvailability() {
		
	}
	
	public void addToWaitlist(Reservation r) {
		waitlist.add(r);
	}
	
	public void removeFromWaitlist(Reservation r) {
		waitlist.remove(r);
	}
	
	public void updateGuestInfo(Guest g) {
		Scanner in = new Scanner(System.in);
		if (choice == 1){
			g.setName(in.next);
		}
	}
	
	public boolean isReserved(Date d) {
		for (Reservation r : reservations) {
			if (r.getDate() == d) {
				return true;
			}
		}
		return false;
	}
	
	public void collectAmountDue() {
		
	}
	
	public void editGuestInfo() {
		
	}
	
	public static void main(String[] args) {

	}

}
