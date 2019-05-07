package FinalExam;

import java.util.Scanner;

public class AquaWorld {
	
	private Scanner in = new Scanner(System.in);
	
	private String desc;
	private String setUp;
	private int capacity = 75;
	private MealPlan mealPlan = new MealPlan();
	private double cost = 700.00;
	private int hours;
	private String[] setUpOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	private String[] mealPlans = {"Bronze", "Silver", "Gold", "Platinum"};
	
	public AquaWorld() {
		desc = "N/A";
		setUp = "N/A";
		capacity = 0;
		cost = 0;
		hours = 0;
		mealPlan = new MealPlan();
	}
	
	public AquaWorld(String desc,String setUp, int capac,int hours, double cost, MealPlan mp) {
		this.desc = "N/A";
		this.setUp = setUp;
		this.capacity = 0;
		this.hours = hours;
		this.cost = cost;
		mealPlan = mp;
	}

	public void upgradeMealPlan() {
		System.out.println("Which meal plan would you like to upgrade to?\n");
		for(String i : mealPlans) { 
			System.out.println(i + " ");
		}
		String choice = in.nextLine();
		
		#Justins Alt Code
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
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSetUp() {
		return setUp;
	}

	public void setSetUp(String setUp) {
		this.setUp = setUp;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public MealPlan getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
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
		setSetUp(in.nextLine());
		cost += 100.00;
	}
	
	public boolean checkGuest() {
		System.out.println("Is customer wearing bathing suit? Y/N?");
		String answer = in.next();
		return(answer.equalsIgnoreCase("y"));
	}
}
