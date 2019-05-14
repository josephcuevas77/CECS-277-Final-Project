package FinalExam;

/**
 * The Super class of all the individual rooms to be reserved
 * Has the instance variables that all the rooms share
 */

public abstract class BaseRoom {

	/**
	 * default constructor
	 */
    public BaseRoom() {
    	roomType = "";
        description = "";
        includedInCost = "";
        capacity = 0;
        costPerHour = 0.0;
        hours = 0;
        descriptionOfAddOns = "\n";
        costOfAddOns = 0.00;
        
        mealPlan = new MealPlan();
    }
    
    /**
     * instance variables
     */
    private String roomType;
    private String description;
	private String includedInCost;
    private int capacity;
    private double costPerHour;
	private int hours;
	private String descriptionOfAddOns;
	private double costOfAddOns;
    private MealPlan mealPlan;

    public String getRoomType() {return roomType;}
    public void setRoomType(String roomType) {this.roomType = roomType;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getIncludedInCost() {return includedInCost;}
    public void setIncludedInCost(String str) {includedInCost = str;}
    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
    public double getCostPerHour() {return costPerHour;}
    public void setCostPerHour(double costPerHour) {this.costPerHour = costPerHour;}
    public int getHours() {return hours;}
    public void setHours(int hrs) {hours = hrs;}
    public String getDescriptionOfAddOns() {return descriptionOfAddOns;}
    public void updateDescriptionOfAddOns(String addOn) {descriptionOfAddOns += addOn + "\n";}
    public double getCostOfAddOns() {return costOfAddOns;}
    public void updateCostOfAddOns(double price) {costOfAddOns += price;}
    public MealPlan getMealPlan() {return mealPlan;}
    public void setMealPlan(MealPlan mealPlan) {this.mealPlan = mealPlan;}
    
    public double getFlatRateFee() {
    	return costPerHour * hours;
    }
    
    /**
     * gets the final cost after how many hours the room has been used
     * and the meal plan bought
     * @return the final cost of the room
     */
    public abstract double getFinalCost();
    
    public String toString() {
    	String str = "Room: %s\nDescription: %s\nIncluded in cost: %s\nCapacity: %d\nCost per hour: $%.2f\nDuration of reservation: %d hours\n%s\nRoom Add-ons: %s\nPrice of all add-ons: $%.2f\nFinal Price: $%.2f\n";
    	return String.format(str, roomType, description, includedInCost, capacity, costPerHour, hours,mealPlan, descriptionOfAddOns, costOfAddOns, getFinalCost());
    }
}
