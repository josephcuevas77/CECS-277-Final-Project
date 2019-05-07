package FinalExam;

import java.util.Scanner;

public class AquaWorld {
	
	private Scanner in = new Scanner(System.in);
	private double cost = 700.00;
	private int hours;
	private String[] setUpOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};

	public void upgradeMealPlan() {
		
	}
	
	public void rentTowel() {
		double add = 0.0;
		System.out.println("How many towels would you like to rent?");
		int amount = in.nextInt();
		add += (5 * amount);
		cost+= add;
	}
	
	public void orderPartyBagFavor() {
		double add = 0.0;
		System.out.println("How many bags would you like to order?");
		int amount = in.nextInt();
		add += (5 * amount);
		cost+= add;
	}
	
	public void includeProjector() {
		double add = 0.0;
		System.out.println("How many hours would you like to rent the projector?");
		int hours = in.nextInt();
		add += (10 * hours);
		cost+= add;
	}
	
	public void setUp() {
		System.out.println("Which Theme Set-Up would you like?");
		for(String i : setUpOptions) { 
			System.out.println(i + " ");
		}
		cost += 100.00;
	}
	
	public boolean checkGuest() {
		
	}
}
