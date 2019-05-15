package FinalExam;

public class KaraokeLounge extends BaseRoom {
	
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
	public KaraokeLounge() {
		setRoomType("KaraokeLounge");
		setDescription("Enclosed Lounge with Karaoke Machine");
		setIncludedInCost("Access to Karaoke Machine");
		setCapacity(10);
		setCostPerHour(30.00);
		setMealPlan(null);
	}
	
	public void upgradeMealPlan(int num) {
		setMealPlan(new MealPlan(num));
		getMealPlan().setCost(getMealPlan().getCost());
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
