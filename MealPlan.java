//Justin Mabutas
//Low-key finished

public class MealPlan {

    public static void main(String[] args) {
        MealPlan standard = new MealPlan(15.0, "Standard");
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
        return String.format("Cost: %f.2f \nDescription: %s", cost, description);
    }
}
