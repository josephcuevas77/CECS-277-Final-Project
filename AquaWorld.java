package FinalExam;

import java.util.Scanner;

public class AquaWorld extends BaseRoom{
	
	private String desc;
	private String includedInCost;
	private String setUp;
	private int capacity = 75;
	private double cost;
	private int hours;
	private MealPlan mealPlan = new MealPlan();
	private final double costPerHour = 700.00;
	private String[] setUpOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	
	/**
	 * Default constructor for AquaWorld Room
	 */
	public AquaWorld() {
		desc = "Olympic-sized pool with water slide, kiddie pool, and large jacuuzi.";
		includedInCost = "Access to showers/lockers, life guards on duty, DJ, table & chair set-up, Basic Meal Plan";
		capacity = 75;
		hours = 0;
		cost = 0;
		mealPlan = new MealPlan();
	}
	
	/**
	 * gets Description
	 * @return description
	 */
	public String getDesc() {
		return desc;
	}
	
	/**
	 * gets getIncludedContent
	 * @return description
	 */
	public String getIncludedContent() {
		return includedInCost;
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
		cost += 100;
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
	 * adds 
	 */
	public void rentTowel(int num) {
		cost += 5*num;
	}
	
	/**
	 * allows employee to add party bag faovrs if customer likes
	 */
	public void orderPartyBagFavor(int num) {
		cost+= 5*num;
	}
	
	/**
	 * adds to cost if customer wants a projector. 1 hr = $10
	 */
	public void includeProjector(int timeInHours) {
		cost+= 10*timeInHours;
	}
	
	/**
	 * Checks if guest is wearing bathing suit to enter
	 * @return boolean based on response
	 */
	public boolean checkGuest() {
		//Implement later. No idea what to do
		return false;
	}

	/**
	 * getFinalCost
	 * returns flat rate fee per hour + any further expenses
	 */
	@Override
	public double getFinalCost() {
		return cost + costPerHour*hours;
	}
}
