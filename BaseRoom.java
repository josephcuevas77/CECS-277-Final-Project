public abstract class BaseRoom {

    private String description;
    private int capacity;
    private int costPerHour;
    private MealPlan MealPlan;

    public abstract int getFinalCost();
    public abstract void createRoom(Baseroom room);
}
