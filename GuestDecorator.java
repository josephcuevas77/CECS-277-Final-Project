package FinalExam;

import java.util.Scanner;

/**
* Extension of Guest that allows for more methods
*/
public class GuestDecorator {
	
	private Scanner in = new Scanner(System.in);

	/**
	* Indicates that guset would like to check in to room reserved
	*/
	public void checkIn() {
		System.out.println("I would like to check in!");
	}
	
	/**
	* Indicates that guset would like to check out of room reserved
	*/
	public void checkOut() {
		System.out.println('I would like to check out!");
	}
	
	/**
	* Prompts for info of guest to be entered into the system
	*/
	public void enterGuestInfo(Guest guest) {
		System.out.print("Name of Guest: ");
		guest.setName(in.nextLine());
		
		System.out.print("\nPhone Number: ");
		guest.setPhoneNumber(in.nextLine());
		
		System.out.print("\nEmail: ");
		guest.setEmail(in.nextLine());
		
		System.out.print("\nCredit Card Info: ");
		guest.setCreditCardInfo(in.nextLine());
		
		System.out.print("\nEnter the Date of Reservation: MM/DD/YYYY");
		String[] stringDate = in.nextLine().split("/");
		int[] date = new int[stringDate.length];
		for(int i = 0; i < stringDate.length; i++) date[i] = Integer.parseInt(stringDate[i]);
		guest.setDate(new Date(date[0], date[1], date[2]));
			      
		System.out.print("\nEnter the Time of Reservation: HH:MM");
		guest.setTime(in.nextLine());
		
		System.out.print("\nEnter Extra Information or Additional Requests: ");
		guest.setExtraInfo(in.nextLine());
	}
}
