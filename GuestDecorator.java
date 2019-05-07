package FinalExam;

import java.util.Scanner;

public class GuestDecorator {
	
	private Scanner in = new Scanner(System.in);

	public void checkIn() {
		
	}
	
	public void checkOut() {
		
	}
	
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
		guest.setDate(new Date(date[0], date[1], date[2]);
			      
		System.out.print("\nEnter the Time of Reservation: HH:MM);
		guest.setTime(in.nextLine());
		
		System.out.print("\nEnter Extra Information or Additional Requests: );
		guest.setExtraInfo(in.nextLine());
	}
}
