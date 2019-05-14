package FinalExam;

import java.util.ArrayList;

/**
 * Meal Plan has instance variables MealPlan (Tier), Description, and Cost.
 * In addition, it has ArrayLists of pizzas, Wings, IceCreams, and sodas
 * 	that are modified based on the customer. 
 */
public class MealPlan {
	
	//Testing area: This is how this class should be implemented.
    public static void main(String[] args) {
    	MealPlan basic = new MealPlan();
    	System.out.println(basic);
    	
    	MealPlan plat = new MealPlan(4);
    	plat.addPizza("Pepperoni, Ham, Sausage, Mushroom");
    	plat.addPizza("Pepperoni, Ham, Sausage, Mushroom");
    	plat.addPizza("Pepperoni, Ham, Sausage, Mushroom");
    	plat.addPizza("Pepperoni, Ham, Sausage, Mushroom");
    	plat.addSoda("Coca-Cola");
    	plat.addSoda("Coca-Cola");
    	plat.addSoda("Sprite");
    	plat.addSoda("Sprite");
    	plat.addSoda("Sprite");
    	plat.addSalad();
    	plat.addbreakSticks();
    	plat.addWings("Diablo");
    	plat.addWings("Lemon-Pepper");
    	plat.addIceCream("Chocolate");
    	plat.addIceCream("Vanilla");
    	System.out.println(plat);
    }
    
	//0: Basic, 1: Bronze, 2: Silver...
	public static String[] mealPlans = {"Basic", "Bronze", "Silver", "Gold", "Platinum"};
	public static String[] mealPlanDescription = {
			"3 XL 1 Topping Gourmet Pizza\n3 2L Soda Bottles", //Basic
			"3 XL 2 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad or bread-sticks",//Bronze
			"3 XL 3Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad\nBreak-sticks",//Silver
			"3 XL 3 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad\nBread-sticks\nChoice of 2 chicken wing flavors (Spicy mild, Lemon-pepper, BBQ, Sesame, or Diablo). Pick bone-in or boneless.",//Gold
			"4 XL 4 Topping Gourmet Pizzas\n5 2L Soda Bottles\nSalad\nBread-sticks\nChoice of 2 chicken wing flavors (Spicy mild, Lemon-pepper, BBQ, Sesame, or Diablo). Pick bone-in or boneless.\n2 Flavors of Ice cream (Chocolate, Vanilla, Strawberry)",//Platinum
	};
	public static Double[] mealCosts = {65.00, 75.00, 90.00, 120.00, 150.00};
	public static String[] pizzaToppings = "Cheese Pepperoni Ham Jalapeno Sausage Mushroom Pineapple Bell_Pepper Onion Garlic_Chicken".split(" ");
    public static String[] wingFlavors = "Mild_Spicy Diable Lemon_Pepper BBQ Sesame".split(" ");
    public static String[] iceCreamFlavors = "Chocolate_Fudge Vanilla_Bean Strawberry_Shortcake Choco-mint Butter_Pecan".split(" ");
    public static String[] sodaBottles = "Coca-Cola Diet_Coke Canada_Dry Orange_Crush Squirt Root_Beer".split(" ");

    private String mealPlan = "";
    private double cost=0;
    private String description = "";
    private ArrayList<String> pizzas = new ArrayList<String>();
    private ArrayList<String> sodas = new ArrayList<String>();
    private boolean hasBreadSticks = false;
    private boolean hasSalad = false;
    private ArrayList<String> wings = new ArrayList<String>();
    private ArrayList<String> iceCreams = new ArrayList<String>();
    
    /**
     * Default Constructor: Creates a Basic Meal plan
     * This is how the overloaded constructor would work, swapping 0 for variable choice.
     */
    public MealPlan() {
		mealPlan = mealPlans[0]; //Basic
		cost = mealCosts[0]; //$65.00
		description = mealPlanDescription[0]; //*Insert basic description*
    }
    
    /**
     * Overloaded constructor. See default constructor
     * @param choice: tier of meal plan
     */
    public MealPlan(int choice) {
    	mealPlan = mealPlans[choice];
		cost = mealCosts[choice];
		description = mealPlanDescription[choice]; 
    }
    
    public void addPizza(String pizzaToppings) {
    	pizzas.add("XL Gourmet Pizza with " + pizzaToppings);
    }
    public void addSoda(String sodaFlavor) {
    	sodas.add("2L " + sodaFlavor + " bottle");
    }
    public void addbreakSticks() {
    	hasBreadSticks = true;
    }
    public void addSalad() {
    	hasSalad = true;
    }
    public void addWings(String wingFlavor) {
    	wings.add(wingFlavor + " wings");
    }
    public void addIceCream(String iceCreamFlavor) {
    	iceCreams.add(iceCreamFlavor + " ice cream");
    }
    
    public double getCost() {return cost;}
    public void setCost(double cst) {cost = cst;} 
    public String getDescrition() {return description;}
    public String getSpecifics() {
    	String specifics = "";
    	for(String pizza: pizzas) {specifics += pizza + "\n";}
    	for(String soda: sodas) {specifics += soda + "\n";}
    	if(hasBreadSticks) specifics += "Break Sticks!\n";
    	if(hasSalad) specifics += "Salad!\n";
    	for(String wingFlavor: wings) {specifics += wingFlavor + "\n";}
    	for(String iceCream: iceCreams) {specifics += iceCream + "\n";}
    	if(specifics.equals("")) specifics = "N/A";
    	return specifics;
    }
    public String toString() {
        return String.format("Meal Plan: %s\nCost: %.2f \n-Description- \n%s\n-Meal Plan Specifics-\n%s\n", mealPlan, cost, description, getSpecifics());
    }
}
