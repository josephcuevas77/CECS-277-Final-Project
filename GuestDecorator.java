package FinalExam;

import java.util.Scanner;

public class GuestDecorator {
	
	private Scanner in = new Scanner(System.in);

	public void checkIn() {
		
	}
	
	public void checkOut() {
		
	}
	
	public void enterGuestInfo(Guest guest) {
		System.out.println("Name of Guest: ");
		guest.setName(in.nextLine());
		System.out.println("\nPhone Number: ");
		guest.setPhoneNumber(in.nextLine());
		System.out.println("\nEmail: ");
		guest.setEmail(in.nextLine());
		System.out.println("\nCredit Card Info: ");
		guest.setCreditCardInfo(in.nextLine());
		System.out.println("\nEnter the Date of Reservation: MM/DD/YYYY");
		String date = in.nextLine();
		date.split("/");
	}
}
