import java.util.Scanner;

public class MediumPartyRoom {
	
	private Scanner in = new Scanner(System.in);
	
	private String desc;
	private String setUp;
	private int capacity = 45;
	private MealPlan mealPlan = new MealPlan();
	private double cost = 250.00;
	private int hours;
	private String[] setUpOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	private String[] mealPlans = {"Bronze", "Silver", "Gold", "Platinum"};
	
	/**
	 * Default constructor for Medium Party Room
	 */
	public MediumPartyRoom() {
		desc = "N/A";
		setUp = "N/A";
		capacity = 0;
		cost = 0;
		hours = 0;
	}
	
	/**
	 * Overloaded Constructor of MediumPartyRoom 
	 * @param desc - description of room
	 * @param setUp - decorations of Room
	 * @param capac - capacity of Room
	 * @param hours - hours reserved
	 * @param cost - cost of room
	 * @param mp - meal plan of room
	 */
	public MediumPartyRoom(String desc,String setUp, int capac,int hours, double cost) {
		this.desc = desc;
		this.setUp = setUp;
		this.capacity = capac;
		this.hours = hours;
		this.cost = cost;
	}

	/**
	 * Allows the Employee to upgrade the meal plan if customer requests
	 */
	public void upgradeMealPlan() {
		System.out.println("Which meal plan would you like to upgrade to?\n");
		for(String i : mealPlans) { 
			System.out.println(i + " ");
		}
		String choice = in.nextLine();
		
		//Justins Alt Code
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
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * sets the meal plan to desired one
	 * @param mealPlan of room
	 */
	public MealPlan getMealPlan() {
		return mealPlan;
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
		setSetUp(in.nextLine());
		cost += 100.00;
	}
}
