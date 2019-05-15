package FinalExam;

public class AdultsBilliardsLounge extends BaseRoom {
	
	public static void main(String[] args) {
		KaraokeLounge test = new KaraokeLounge();
		test.setHours(4);
		test.upgradeMealPlan(4);
		System.out.println(test);
	}
	
	public static String[] setupOptions = {"Hawaiian", "Sea Life", "Jungle", "Space"," Modern"};
	
	/**
	 * Default constructor for KaraokeLounge Room
	 */
	public AdultsBilliardsLounge() {
		setRoomType("KaraokeLounge");
		setDescription("Enclosed lounge with pool table");
		setIncludedInCost("Access to Pool Table and Cues");
		setCapacity(10);
		setCostPerHour(25.00);
		setMealPlan(null);
	}
	
	public void upgradeMealPlan(int num) {
		setMealPlan(new MealPlan(num));
		getMealPlan().setCost(getMealPlan().getCost());
	}
	
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
		return getFlatRateFee() + getCostOfAddOns() + getMealPlan().getCost();
	}
}
