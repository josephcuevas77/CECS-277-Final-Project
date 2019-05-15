package FinalExam;

public class MediumPartyRoom extends BaseRoom implements PartyRoomDecorator {
	
	public static void main(String[] args) {
		AquaWorld test = new AquaWorld();
		test.setHours(4);
		test.rentTowel(5);
		test.orderPartyBagFavor(10);
		test.includeProjector(7);
		test.setSetup(2);
		test.upgradeMealPlan(4);
		System.out.println(test);
	}
	
	public static String[] setupOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	
	/**
	 * Default constructor for AquaWorld Room
	 */
	public MediumPartyRoom() {
		setRoomType("Medium Party Room");
		setDescription("Room with party tables and chairs, quick access to arcade.");
		setIncludedInCost("Table & chair set-up, DJ, Basic Meal Plan");
		setCapacity(45);
		setCostPerHour(250.00);
		setMealPlan(new MealPlan());
	}
	
	public void upgradeMealPlan(int num) {
		double previousMealPlanCost = getMealPlan().getCost();
		setMealPlan(new MealPlan(num));
		getMealPlan().setCost(5*(getMealPlan().getCost()-previousMealPlanCost));
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
