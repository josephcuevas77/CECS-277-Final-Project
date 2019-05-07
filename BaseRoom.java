public abstract class BaseRoom {

    public BaseRoom() {
        description = "";
        capacity = 0;
        costPerHour = 0.0;
        mealPlan = new MealPlan();
    }
    
    public BaseRoom(String desc, int capa, double cost, MealPlan mp) {
        description = desc;
        capacity = capa;
        costPerHour = cost;
        mealPlan = mp;
    }
    
    private String description;
    private int capacity;
    private double costPerHour;
    private MealPlan mealPlan;

    public abstract double getFinalCost();
    public abstract void createRoom(Baseroom room);
}
