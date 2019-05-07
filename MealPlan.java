package FinalExam;

import java.util.Scanner;

public class MealPlan {
	
	public static String[] mealPlans = {"Bronze", "Silver", "Gold", "Platinum"};

    public static void main(String[] args) {
    	MealPlan test = new MealPlan();
    	System.out.println(test.getDescrition());
    }
    
    /**
     * Default Constructor for basic mealPlan
     */
    public MealPlan() {
		for(int i = 0; i < 3; i++)
			addPizza(1);
    }
    
    /**
     * Overloaded constructor for more toppings/pizzas with meal plan
     * @param type - type of mealPlan
     */
    public MealPlan(String type) {
    	switch(type) {
    		case("bronze"):
    			for(int i = 0; i < 3; i++)
    				addPizza(2);
				break;
    		case("silver"):
    			for(int i = 0; i < 3; i++)
    				addPizza(3);
				break;
    		case("gold"):
    			for(int i = 0; i < 3; i++)
    				addPizza(3);
				break;
    		case("platinum"):
    			for(int i = 0; i < 4; i++)
    				addPizza(4);
				break;
    		default:
			System.out.println("That meal plan does not exist");
    	}
    	scan.close();
    }
    
    private Scanner scan = new Scanner(System.in);
    
    private double cost;
    private String description = "";
    private String[] pizzaToppings = "Cheese Pepperoni Ham Jalapeno Sausage Mushroom Pineapple Bell_Pepper Onion Garlic_Chicken".split(" ");
    private String[] wingFlavors = "Mild_Spicy Diable Lemon_Pepper BBQ Sesame".split(" ");
    private String[] iceCreamFlavors = "Chocolate_Fudge Vanilla_Bean Strawberry_Shortcake Choco-mint Butter_Pecan".split(" ");
    private String[] sodaBottles = "Coca-Cola Diet_Coke Canada_Dry Orange_Crush Squirt Root_Beer".split(" ");

    /**
     * These functions are used for the description
     * @param numToppings - number of Toppings on pizza
     */
    private void addPizza(int numToppings) {
    	System.out.println(String.format("For your %d topping pizza :^D", numToppings));
    	String temp = "Pizza\n Toppings: ";
    	for(int i = 0; i < pizzaToppings.length; i++) {
    		System.out.print(pizzaToppings[i] + "    ");
    		if(i % 3 == 2) System.out.println("");
    	}
    	System.out.println("");
    	for(int i = 0; i < numToppings; i++) {
    		System.out.print(String.format("Enter topping %d: ", i+1));
    		temp += scan.nextLine() + "\n";
    	}
    	description += temp + "\n";
    }
    
    public double getCost() {return cost;}
    public String getDescrition() {return description;}
    
    public String[] getPizzaToppings() {return pizzaToppings;}
    public String[] getWingFlavors() {return wingFlavors;}
    public String[] getIceCreamFlavors() {return iceCreamFlavors;}
    public String[] getSodeBottles() {return sodaBottles;}

    /**
     * Allows the MealPlan object to be printed out
     */
    public String toString() {
        return String.format("Cost: %.2f \nDescription: \n%s", cost, description);
    }
}
