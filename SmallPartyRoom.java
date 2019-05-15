package FinalExam;

public class SmallPartyRoom extends BaseRoom implements PartyRoomDecorator{
	
	public static void main(String[] args) {
		SmallPartyRoom test = new SmallPartyRoom();
		test.orderPartyBagFavor(2);
		test.includeProjector(4);
		test.setSetup(1);
		System.out.println(test);
	}
	
	public static String[] setupOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	
	/**
	 * Default constructor for AquaWorld Room
	 */
	public SmallPartyRoom() {
		setRoomType("Small Party Room");
		setDescription("Room with party tables and chairs, adjacent to arcade");
		setIncludedInCost("Table & chair set-up, Basic Meal Plan");
		setCapacity(30);
		setCostPerHour(150.00);
		setMealPlan(new MealPlan());
	}
	
	public void upgradeMealPlan(int num) {
		double previousMealPlanCost = getMealPlan().getCost();
		setMealPlan(new MealPlan(num));
		getMealPlan().setCost((getMealPlan().getCost()-previousMealPlanCost));
	}
	
	public void setSetup(int num) {
		updateDescriptionOfAddOns("Setup: " + setupOptions[num] + " ($100.00)\n");
		updateCostOfAddOns(100);
	}
	
	public void orderPartyBagFavor(int num) {
		updateDescriptionOfAddOns(String.format("%d party bag favors ($%.2f)\n", num, num*5.0));
		updateCostOfAddOns(5*num);
	}
	
	public void includeProjector(int timeInHours) {
		updateDescriptionOfAddOns(String.format("%d hours of projector use ($%.2f)\n", timeInHours, timeInHours*10.0));
		updateCostOfAddOns(10*timeInHours);
	}

	/**
	 * getFinalCost
	 * returns flat rate fee per hour + any further expenses
	 */
	@Override
	public double getFinalCost() {
		return getFlatRateFee() + getCostOfAddOns() + getMealPlan().getCost();
	}
}
