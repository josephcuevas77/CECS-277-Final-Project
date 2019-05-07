import java.util.Scanner;

public class KaraokeLounge {
	
	private Scanner in = new Scanner(System.in);
	
	private String desc;
	private String setUp;
	private int capacity = 10;
	private MealPlan mealPlan = new MealPlan();
	private double cost = 30.00;
	private int hours;
	private String[] mealPlans = {"Basic", "Bronze", "Silver", "Gold", "Platinum"};
	
	/**
	 * Default Constructor: Sets all values to N/A or 0
	*/
	public KaraokeLounge() {
		desc = "N/A";
		setUp = "N/A";
		capacity = 0;
		hours = 0;
	}
	
	/**
	 * Overloaded Constructor
	 * @param: description
	 * @param: setup
	 * @param: capacity
	 * @param: hours
	 * @param: description
	*/
	public KaraokeLounge(String desc,String setUp, int capac,int hours) {
		this.desc = desc;
		this.setUp = setUp;
		this.capacity = capac;
		this.hours = hours;
	}

	/**
	 * Instantiates Meal Plan object
	 * Prompts user for which meal plan will be added
	*/
	public void addMealPlan() {
		System.out.println("Which meal plan would you like to add?\n");
		for(String i : mealPlans) { 
			System.out.println(i + " ");
		}
		String choice = in.nextLine();
		
		//Justins Alt Code
		MealPlan temp = new MealPlan(choice);
		mealPlan = temp;
		
		switch(choice) {
			case "Bronze":
				cost += (75);
				break;
			case "Silver":
				cost += (90);
				break;
			case "Gold":
				cost += (120);
				break;
			case "Platinum":
				cost += (150);
				break;
			default: 
				cost += (65);
		}
	}	
	
	/**
	 * Getter method for the description of the room
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Getter method for the setup of the room
	 * @return setUp
	 */
	public String getSetUp() {
		return setUp;
	}

	/**
	 * Getter method for the capacity of the room
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Returns the current meal plan of the room
	 * @return mealPlan
	 */
	public MealPlan getMealPlan() {
		return mealPlan;
	}

	/**
	 * Returns the final cost of the meal
	 * @return cost per hour
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Returns the hours of the rooms reservation
	 * @return
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Sets the hours of the rooms reservation
	 * @param hours
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * Adds cost of party bag favors to total cost
	 */
	public void orderPartyBagFavor() {
		double add = 0.0;
		System.out.println("How many bags would you like to order?");
		int amount = in.nextInt();
		add += (5 * amount);
		cost+= add;
	}
	
	/**
	 * Adds cost of including the projector
	 */
	public void includeProjector() {
		double add = 0.0;
		System.out.println("How many hours would you like to rent the projector?");
		int hours = in.nextInt();
		add += (10 * hours);
		cost+= add;
	}
	
	/**
	 * Prompts the user for which setup will be used
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
