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
	
	public KaraokeLounge() {
		desc = "N/A";
		setUp = "N/A";
		capacity = 0;
		cost = 0;
		hours = 0;
	}
	
	public KaraokeLounge(String desc,String setUp, int capac,int hours, double cost) {
		this.desc = desc;
		this.setUp = setUp;
		this.capacity = capac;
		this.hours = hours;
		this.cost = cost;
	}

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
}