package FinalExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Master class/Employee that has control over all rooms, guest info, and reservations 
 *
 */
public class FrontDeskAgent {
	
	private static ConcreteRoomFactory factory = new ConcreteRoomFactory();
	private static ArrayList<Guest> guests = new ArrayList<Guest>();
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private static ArrayList<Reservation> waitlist = new ArrayList<Reservation>();

	private static ArrayList<AquaWorld> AquaWorldRooms = new ArrayList<AquaWorld>();
	private static ArrayList<SmallPartyRoom> SmallPartyRooms = new ArrayList<SmallPartyRoom>();
	private static ArrayList<MediumPartyRoom> MediumPartyRooms = new ArrayList<MediumPartyRoom>();
	private static ArrayList<KaraokeLounge> KaraokeLounges = new ArrayList<KaraokeLounge>();
	private static ArrayList<AdultsBilliardsLounge> AdultBilliardsLounges = new ArrayList<AdultsBilliardsLounge>();

	public static void generateAllRooms() {
		if(AquaWorldRooms.size()==0) 
			for(int i = 0 ; i < BaseRoomFactory.MAX_AQUA_WORLD_ROOMS; i++) factory.createRoom(0);
		if(SmallPartyRooms.size()==0)
			for(int i = 0 ; i < BaseRoomFactory.MAX_SMALL_PARTY_ROOMS; i++) factory.createRoom(1);
		if(MediumPartyRooms.size()==0)
			for(int i = 0 ; i < BaseRoomFactory.MAX_MEDIUM_PARTY_ROOMS; i++) factory.createRoom(2);
		if(KaraokeLounges.size()==0)
			for(int i = 0 ; i < BaseRoomFactory.MAX_KARAOKE_LOUNGE; i++) factory.createRoom(3);
		if(AdultBilliardsLounges.size()==0)
			for(int i = 0 ; i < BaseRoomFactory.MAX_ADULT_BILLIARDS_LOUNGE; i++) factory.createRoom(4);
	}
	
	/**
	 * Views if room is available at the time requested
	 * @return boolean of true if room is free and false if otherwise
	 */
	public boolean viewAvailability(Guest guest, int roomType, int month, int day, int year) {
//		System.out.print("Enter the Date of Reservation: MM/DD/YYYY: ");
//		String d = in.next();
//		String[] stringDate = d.split("/");
//		int[] date = new int[stringDate.length];
//		for(int i = 0; i < stringDate.length; i++) date[i] = Integer.parseInt(stringDate[i]);
		guest.setDate(new Date(month, day, year));
		
		int max = 0;
		switch(roomType) {
		case(0):
			max = 1;
		case(1):
			max = 10;
		case(2):
			max = 2;
		case(3):
			max = 10;
		case(4):
			max = 15;
		}
		int counter = 0;
		while(counter < max) {
			for(Reservation i: reservations) {
				if (guest.getDate().equals(i.getDate()) && i.getBaseRoom().getRoomType().equals(roomType)) {
					counter++;
				}	
			}
			return false;
		}
		return true;
	}
	
	public static ArrayList<Guest> getGuests() {
		return guests;
	}
	
	public static ArrayList<Reservation> getWaitList() {
		return waitlist;
	}
	
	/**
	 * Adds reservation to waitlist if full
	 * @param r - reservation to be added
	 */
	public static void addToWaitlist(Reservation r) {
		waitlist.add(r);
	}
	
	/**
	 * Removes reservation from waitlist
	 * @param r - reservation
	 */
	public static void removeFromWaitlist(Reservation r) {
		waitlist.remove(r);
	}
	
	public static void addReservation(Reservation r) {
		reservations.add(r);
	}
	
	public static void removeReservation(Reservation r) {
		reservations.remove(r);
	}
	
	/**
	 * updates the guest info
	 * @param g - guest
	 */
	public static void updateGuestInfo(Guest g, String name, String phoneNumber, String email, String creditCardInfo, Date date, String time, String mealPlanInfo, String extraInfo) {		
//		System.out.print("What would u like to change? \n1. Name\n2. Phone Number\n3. Email\n4. Credit Card Info"
//				+ "\n5. Date\n6. Time\n7. MealPlan\n8. Extra Info\nOption: ");
//		int choice = in.nextInt();
//		System.out.println();
//		switch (choice) {
//			case(1):
//				System.out.print("Change Name: ");
//				g.setName(in.next());
//				break;
//			case(2):
//				System.out.print("Change Phone Number: ");
//				g.setPhoneNumber(in.next());
//				break;
//			case(3):
//				System.out.print("Change Email: ");
//				g.setEmail(in.next());
//				break;
//			case(4):
//				System.out.print("Change Credit Card Info: ");
//				g.setCreditCardInfo(in.next());
//				break;
//			case(5):
//				System.out.print("Enter the Date of Reservation in MM/DD/YYYY: ");
//				String d = in.next();
//				String[] stringDate = d.split("/");
//				int[] date = new int[stringDate.length];
//				for(int i = 0; i < stringDate.length; i++) date[i] = Integer.parseInt(stringDate[i]);
//				g.setDate(new Date(date[0], date[1], date[2]));
//				break;
//			case(6):
//				System.out.print("Change Time: ");
//				g.setTime(in.next());
//				break;
//			case(7):
//				System.out.print("Change MealPlan: ");
//				g.setMealPlanInfo(in.next());
//				break;
//			case(8):
//				System.out.print("Change Extra Info: ");
//				g.setExtraInfo(in.next());
//				break;
//		}
		g.setName(name);
		g.setPhoneNumber(phoneNumber);
		g.setEmail(email);
		g.setCreditCardInfo(creditCardInfo);
		g.setDate(date);
		g.setTime(time);
		g.setMealPlanInfo(mealPlanInfo);
		g.setExtraInfo(extraInfo);
	}
	
	/**
	 * checks if a room is reserved
	 * @param d - date of reservation
	 * @return true if reserved and false otherwise
	 */
	public static boolean isReserved(Date d) {
		for (Reservation r : getReservations()) {
			if (r.getDate().equals(d)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Collects money from customer
	 */
	public static boolean collectAmountDue(Reservation r, int amount) {
		BaseRoom room = r.getBaseRoom();
		Guest g = r.getGuest();
		double cost = room.getFinalCost();
//		System.out.println("Amount Due: $" + cost);
//		double payment = in.nextDouble();
		if(amount >= cost) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the list of reservations
	 * @return
	 */
	public static ArrayList<Reservation> getReservations() {
		return reservations;
	}
	
	public static void main(String[] args) {
		FrontDeskAgent f = new FrontDeskAgent();
		Guest g = new Guest();
		while (true) {
		f.updateGuestInfo(g);
		System.out.println();
		System.out.println(g.toString());
		}
	}


}