//Justin Mabutas

public class MealPlan {

    //$65
    private static final String BASIC = "\n3 XL 1 Topping Gourmet Pizzas\n32L Soda Bottles";
    //$75
    private static final String BRONZE = "\n3 XL 2 Topping Gourmet Pizzas\n52L Soda Bottles\nSalad or bread-sticks";
    //$90
    private static final String SILVER = "\n3 XL 2 Topping Gourmet Pizzas\n52L Soda Bottles\nSalad\nBreak-sticks";


    public static void main(String[] args) {
        MealPlan standard = new MealPlan(65.0, MealPlan.BASIC);
        MealPlan bronze = new MealPlan(75.0, MealPlan.BRONZE);
        MealPlan silver = new MealPlan(75.0, MealPlan.SILVER);
        System.out.println(String.format("%s\n%s\n%s", standard, bronze, silver));
    }

    public MealPlan(double cost, String description) {
        this.cost = cost;
        this.description = description;
    }

    private double cost;
    private String description;
    private String[] pizzaToppings;
    private String[] wingFlavors;
    private String[] iceCreamFlavors;
    private String[] sodaBottles;

    public double getCost() {return cost;}
    public void setCost(double cost) {this.cost = cost;}
    public String getDescrition() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String[] getPizzaToppings() {return pizzaToppings;}
    public String[] getWingFlavors() {return wingFlavors;}
    public String[] getIceCreamFlavors() {return iceCreamFlavors;}
    public String[] getSodeBottles() {return sodaBottles;}

    public String toString() {
        return String.format("Cost: %.2f \nDescription: %s", cost, description);
    }
}