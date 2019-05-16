package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class NewReservationFrame extends JFrame {

	public static void main(String[] args) {
		NewReservationFrame hi = new NewReservationFrame();
		hi.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JCheckBox checkBox; 
	private JComboBox<String> comboBox;
	private JPanel panel = new JPanel();
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;

	private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	private ArrayList<JComboBox<String>> comboBoxes = new ArrayList<JComboBox<String>>();
	

	private JButton saveButton = new JButton("Save");

	private JButton cancelButton = new JButton("Cancel");
	
	private String[] guestInfo = {"Name", "Phone Number", "Address", "Date of Reservation", "Email", "Address", "Extra Info"};
	private String[] creditCard = {"Name", "Number", "Security Code", "Expiration Date"};
	
	public NewReservationFrame() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("New Reservation Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void createComponents(){
		SuperListener listener = new SuperListener();
		
		
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
		checkBoxes.add(checkBox);
		checkBox = new JCheckBox("Contact via Email"); 
		panel.add(checkBox);
		checkBoxes.add(checkBox);
		
//		createComboBox(ConcreteRoomFactory.ROOMS, "Rooms: ", panel, comboBoxes);
//		createComboBox(MealPlan.mealPlans, "Meal Plans: ", panel, comboBoxes);
//		createComboBox(MealPlan.pizzaToppings, "Pizza Toppings: ", panel, comboBoxes);
//		createComboBox(MealPlan.sodaBottles, "Soda Choices: ", panel, comboBoxes);
//		createComboBox(MealPlan.iceCreamFlavors, "Ice Cream Flavors: ", panel, comboBoxes);
//		createComboBox(MealPlan.wingFlavors, "Wing Flavors: ", panel, comboBoxes);


		comboBox = new JComboBox<String>(ConcreteRoomFactory.ROOMS);
		comboBoxes.add(comboBox);		
		panel.add(comboBox);
		
		comboBox = new JComboBox<String>(MealPlan.mealPlans);
		comboBoxes.add(comboBox);
		panel.add(comboBox);
		
		comboBox = new JComboBox<String>(MealPlan.pizzaToppings);
		comboBoxes.add(comboBox);
		panel.add(comboBox);
		
		comboBox = new JComboBox<String>(MealPlan.sodaBottles);
		comboBoxes.add(comboBox);
		panel.add(comboBox);
		
		comboBox = new JComboBox<String>(MealPlan.iceCreamFlavors);
		comboBoxes.add(comboBox);
		panel.add(comboBox);
		
		comboBox = new JComboBox<String>(MealPlan.wingFlavors);
		comboBoxes.add(comboBox);
		panel.add(comboBox);
		
		saveButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		panel.add(saveButton);
		panel.add(cancelButton);

		add(panel);
	}
	
//	public JComboBox<String> createComboBox(String[] options, String title, JPanel panel, ArrayList<JComboBox<String>> comboList) {
//		createLabel(title, panel);
//		JComboBox<String> comboBox = new JComboBox<String>(options);
//		comboList.add(comboBox);
//		panel.add(comboBox);
//		return comboBox;
//	}
	
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
		textFields.add(textField);
		p.add(panel);
	}
	
	class SuperListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			//textFields[0-11]
			//checkBoxes[0-1]
			//comboList[0-5]
			
			//Save Button
			if(event.getSource() == saveButton) {
//				for(JTextField text: textFields) {
//					System.out.println(text.getText());
//				}
//				for(JCheckBox box: checkBoxes) {
//					System.out.println(box.isSelected());
//				}
//				for(JComboBox<String> combo: comboBoxes) {
//					System.out.println(combo.getSelectedItem());
//				}
				
				String[] dates = textFields.get(3).getText().split("/");
				String creditCardInformation = textFields.get(7).getText() + "\n" + textFields.get(8).getText() + "\n" + textFields.get(9).getText() + "\n" + textFields.get(10).getText();
				Date d = new Date(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
				System.out.println(creditCardInformation);
				Guest g = new Guest(textFields.get(0).getText(), textFields.get(1).getText(), textFields.get(2).getText(), creditCardInformation, d, textFields.get(5).getText(), (String)comboBoxes.get(0).getSelectedItem(), textFields.get(6).getText());
				System.out.println(g);
				
				Reservation r = new Reservation();

//				FrontDeskAgent.addReservation(r);
			}
			
			
			//Cancel Button
			else if(event.getSource() == cancelButton) {
				dispose();
			}
			
		}
	
	}
	
}