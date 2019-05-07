package FinalExam;

import java.util.Scanner;

/**
 * Adult Billiards Lounge Class which objects can be created from factories
 * @author Joseph
 *
 */
public class AdultsBilliardsLounge {

	Scanner in = new Scanner(System.in);
	
	private final int maxRooms = 5;
	private String desc;
	private int capacity = 75;
	private MealPlan mealPlan = new MealPlan();
	private double cost = 25.00;
	private int hours;
	
	/**
	 * Default Constructor for Lounge
	 */
	public AdultsBilliardsLounge() {
		desc = "N/A";
		capacity = 0;
		cost = 0;
		hours = 0;
		mealPlan = new MealPlan();
	}
	
	/**
	 * Overloaded Constructor for Lounge
	 * @param desc - description of Room
	 * @param capac - capacity of Room
	 * @param hours - hour of reserved
	 */
	public AdultsBilliardsLounge(String desc, int capac, int hours) {
		this.desc = desc;
		this.capacity = capac;
		this.hours = hours;
		this.mealPlan = new MealPlan();
	}
	
	/**
	 * Adds a meal plan and adds to cost of overall room
	 */
	public void addMealPlan() {
		System.out.println("Which meal plan would you like to add to your room?\n");
		for(String i : MealPlan.mealPlans) { 
			System.out.println(i + " ");
		}
		String choice = in.nextLine();
		
		//Justins Alt Code
		MealPlan temp = new MealPlan(choice);
		mealPlan = temp;
		
		switch(choice) {
			case "Basic":
				cost += 65.00;
			case "Bronze":
				cost += 75.00;
				break;
			case "Silver":
				cost += 90.00;
				break;
			case "Gold":
				cost += 120.00;
				break;
			case "Platinum":
				cost += 150.00;
				break;
			default:
				System.out.println("Meal Plan does not exist!");
		}
	}
	
	/**
	 * Checks if guest are 21+ and returns bool
	 * @return true if guests are 21+, false otherwise
	 */
	public boolean checkGuest() {
		System.out.println("Are guests 21 or older? Y/N?");
		String answer = in.next();
		return(answer.equalsIgnoreCase("y"));
	}
	
}
