package FinalExam;

import java.util.Scanner;

public class AquaWorld {
	
	private Scanner in = new Scanner(System.in);
	
	private String desc;
	private String setUp;
	private int capacity = 75;
	private double cost;
	private MealPlan mealPlan = new MealPlan();
	private final double costPerHour = 700.00;
	private int hours;
	private String[] setUpOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	
	/**
	 * Default constructor for AquaWorld Room
	 */
	public AquaWorld() {
		desc = "N/A";
		setUp = "N/A";
		capacity = 75;
		cost = 0;
		hours = 0;
		mealPlan = new MealPlan();
	}
	
	/**
	 * Overloaded Constructor of AquaWorld 
	 * @param desc - description of room
	 * @param setUp - decorations of Room
	 * @param capac - capacity of Room
	 * @param hours - hours reserved
	 * @param cost - cost of room
	 * @param mp - meal plan of room
	 */
	public AquaWorld(String desc,String setUp,int hours, double cost, MealPlan mp) {
		this.desc = "N/A";
		this.setUp = setUp;
		this.hours = hours;
		this.cost = cost;
		mealPlan = mp;
	}

	/**
	 * Allows the Employee to upgrade the meal plan if customer requests
	 */
	public void upgradeMealPlan() {
		System.out.println("Which meal plan would you like to upgrade to?\n");
		for(String i : MealPlan.mealPlans) { 
			System.out.println(i + " ");
		}
		String choice = in.nextLine();
		
		MealPlan temp = new MealPlan(choice);
		mealPlan = temp;
		
		switch(choice) {
			case "Bronze":
				cost += (3 * 10);
			case "Silver":
				cost += (3 * 25);
			case "Gold":
				cost += (3 * 55);
			case "Platinum":
				cost += (3 * 85);
		}
	}	
	
	/**
	 * gets Description
	 * @return description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * sets description of room
	 * @param desc - description of room
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * gets Set up of room
	 * @return setUp
	 */
	public String getSetUp() {
		return setUp;
	}

	/**
	 * sets the setUp of room
	 * @param setUp of room
	 */
	public void setSetUp(String setUp) {
		this.setUp = setUp;
	}

	/**
	 * gets Capacity of room
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * gets meal plan of room
	 * @return meal plan
	 */
	public MealPlan getMealPlan() {
		return mealPlan;
	}

	/**
	 * sets the meal plan to desired one
	 * @param mealPlan of room
	 */
	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}

	/**
	 * returns caluclated cost of room
	 * @return
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * gets the amount of hours room is being rented
	 * @return the number of hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * set the number of hours being reserved
	 * @param hours being reserved
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * allows employee to add towels if customer likes
	 */
	public void rentTowel() {
		double add = 0.0;
		System.out.println("How many towels would you like to rent?");
		int amount = in.nextInt();
		add += (5 * amount);
		cost+= add;
	}
	
	/**
	 * allows employee to add party bag faovrs if customer likes
	 */
	public void orderPartyBagFavor() {
		double add = 0.0;
		System.out.println("How many bags would you like to order?");
		int amount = in.nextInt();
		add += (5 * amount);
		cost+= add;
	}
	
	/**
	 * adds to cost if customer wants a projector
	 */
	public void includeProjector() {
		double add = 0.0;
		System.out.println("How many hours would you like to rent the projector?");
		int hours = in.nextInt();
		add += (10 * hours);
		cost+= add;
	}
	
	/**
	 * prompts the customer which set up of decorations they would like
	 */
	public void setUp() {
		System.out.println("Which Theme Set-Up would you like?");
		for(String i : setUpOptions) { 
			System.out.println(i + " ");
		}
		cost += 100.00;
	}
	
	/**
	 * Checks if guest is wearing bathing suit to enter
	 * @return boolean based on response
	 */
	public boolean checkGuest() {
		System.out.println("Is customer wearing bathing suit? Y/N?");
		String answer = in.next();
		return(answer.equalsIgnoreCase("y"));
	}
}
