package FinalExam;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewReservationFrame extends JFrame {

	public static void main(String[] args) {
		NewReservationFrame hi = new NewReservationFrame();
		hi.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JCheckBox checkBox; 
	private JComboBox<String> comboBox;
	private JButton button;
	private JPanel panel = new JPanel();
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	
	private ArrayList<JComboBox<String>> comboBoxes = new ArrayList<JComboBox<String>>();
	
	private String[] guestInfo = {"Name", "Phone Number", "Address", "Date of Birth", "Email", "Address"};
	private String[] creditCard = {"Name", "Number", "Security Code", "Expiration Date"};
	
	public NewReservationFrame() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("New Reservation Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createComponents(){

		panel.add(new JLabel("Guest Information: "));
		for (int i=0; i<guestInfo.length; i++) {
			createText(guestInfo[i], panel);
		}
		
		panel.add(new JLabel("Credit Card Information: "));
		for (int i=0; i<creditCard.length; i++) {
			createText(creditCard[i], panel);
		}
		
		checkBox = new JCheckBox("Contact via Phone"); 
		panel.add(checkBox);
		checkBox = new JCheckBox("Contact via Email"); 
		panel.add(checkBox);
		
		createComboBox(ConcreteRoomFactory.ROOMS, "Rooms: ", panel, comboBoxes);
		createComboBox(MealPlan.mealPlans, "Meal Plans: ", panel, comboBoxes);
		createComboBox(MealPlan.pizzaToppings, "Pizza Toppings: ", panel, comboBoxes);
		createComboBox(MealPlan.sodaBottles, "Soda Choices: ", panel, comboBoxes);
		createComboBox(MealPlan.iceCreamFlavors, "Ice Cream Flavors: ", panel, comboBoxes);
		createComboBox(MealPlan.wingFlavors, "Wing Flavors: ", panel, comboBoxes);


		panel.add(new JLabel("Room: "));
		comboBox = new JComboBox<String>(ConcreteRoomFactory.ROOMS);
		panel.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.mealPlans);
		panel.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.pizzaToppings);
		panel.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.sodaBottles);
		panel.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.iceCreamFlavors);
		panel.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.wingFlavors);
		panel.add(comboBox);
		
		button = new JButton("Save");
		panel.add(button);
		button = new JButton("Cancel");
		panel.add(button);

		add(panel);
	}
	
	public JComboBox<String> createComboBox(String[] options, String title, JPanel panel, ArrayList<JComboBox<String>> comboList) {
		createLabel(title, panel);
		JComboBox<String> comboBox = new JComboBox<String>(options);
		comboList.add(comboBox);
		panel.add(comboBox);
		return comboBox;
	}
	
	public JLabel createLabel(String title, JPanel panel) {
		JLabel label = new JLabel(title);
		panel.add(label);
		return label;
	}
	
	public void createText(String s, JPanel p) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(s);
		textField = new JTextField(20);
		panel.add(label);
		panel.add(textField);
		p.add(panel);
	}
	
}