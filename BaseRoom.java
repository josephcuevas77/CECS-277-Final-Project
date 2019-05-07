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
        description = "";
        capacity = 0;
        costPerHour = 0.0;
        mealPlan = new MealPlan();
    }
    
    /**
     * overloaded constructor
     * @param desc - description of room
     * @param capa - max room capacity
     * @param cost - cost of the room per hour
     * @param mp - meal plan for the party
     */
    public BaseRoom(String desc, int capa, double cost, MealPlan mp) {
        description = desc;
        capacity = capa;
        costPerHour = cost;
        mealPlan = mp;
    }
    
    /**
     * instance variables
     */
    private String description;
    private int capacity;
    private double costPerHour;
    private MealPlan mealPlan;

    /**
     * gets the final cost after how many hours the room has been used
     * and the meal plan bought
     * @return the final cost of the room
     */
    public abstract double getFinalCost();
    /**
     * creates a specific room
     * @param room
     */
    public abstract void createRoom(Baseroom room);
}
