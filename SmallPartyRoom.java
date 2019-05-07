package FinalExam;

import java.util.Scanner;

/**
 * subclass of the BaseRoom super class
 * has its own information and option to add more amenities
 */
public class SmallPartyRoom {
	
	private Scanner in = new Scanner(System.in);
	
	/**
	 * instance variables
	 */
	private String desc;
	private String setUp;
	private int capacity = 30;
	private MealPlan mealPlan = new MealPlan();
	private double cost = 150.00;
	private int hours;
	private String[] setUpOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	private String[] mealPlans = {"Bronze", "Silver", "Gold", "Platinum"};
	
	/**
	 * default constructor
	 */
	public SmallPartyRoom() {
		desc = "N/A";
		setUp = "N/A";
		capacity = 0;
		cost = 0;
		hours = 0;
	}
	
	/**
	 * overloaded constructor
	 * @param desc description of the room
	 * @param setUp decorations of the room
	 * @param capac room capacity size
	 * @param hours reserved for the room
	 * @param cost of the room per hour
	 */
	public SmallPartyRoom(String desc,String setUp, int capac,int hours, double cost) {
		this.desc = desc;
		this.setUp = setUp;
		this.capacity = capac;
		this.hours = hours;
		this.cost = cost;
	}

	/**
	 * option to upgrade the meal plan to a higher level
	 */
	public void upgradeMealPlan() {
		System.out.println("Which meal plan would you like to upgrade to?\n");
		for(String i : mealPlans) { 
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
	 * gets the room description
	 * @return room description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * sets the room description
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * gets the set up of the room
	 * @return room set up
	 */
	public String getSetUp() {
		return setUp;
	}

	/**
	 * sets the set up of the room
	 * @param setUp
	 */
	public void setSetUp(String setUp) {
		this.setUp = setUp;
	}

	/**
	 * gets the room capacity size
	 * @return capacity of room
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * sets the room capacity
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * gets the meal plan for the room
	 * @return meal plan
	 */
	public MealPlan getMealPlan() {
		return mealPlan;
	}

	/**
	 * gets the cost of the room
	 * @return room cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * sets the cost of the room
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * gets the hours reserved for the room
	 * @return hours reserved
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * sets the hours reserved
	 * @param hours
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	/**
	 * option to add optional party bag favors
	 * adds to the cost of the room if bought
	 */
	public void orderPartyBagFavor() {
		double add = 0.0;
		System.out.println("How many bags would you like to order?");
		int amount = in.nextInt();
		add += (5 * amount);
		cost+= add;
	}
	
	/**
	 * option to add projectors
	 * adds to the cost of the room if bought
	 */
	public void includeProjector() {
		double add = 0.0;
		System.out.println("How many hours would you like to rent the projector?");
		int hours = in.nextInt();
		add += (10 * hours);
		cost+= add;
	}
	
	/**
	 * adds any set up decorations that the guest buys
	 * adds to the cost
	 */
	public void setUp() {
		System.out.println("Which Theme Set-Up would you like?");
		for(String i : setUpOptions) { 
			System.out.println(i + " ");
		}
		setSetUp(in.nextLine());
		cost += 100.00;
	}
}
