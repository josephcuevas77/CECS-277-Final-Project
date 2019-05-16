package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class NewReservationFrame extends JFrame {

	public static void main(String[] args) {
		FrontDeskAgent.generateAllRooms();
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
	

	private JButton saveButton = new JButton("Book Now");

	private JButton cancelButton = new JButton("Cancel");
	
	private String[] guestInfo = {"Name", "Date of Birth","Phone Number", "Address", "Date of Reservation", "Time of Reservation", "Email", "Extra Info"};
	private String[] creditCard = {"Name", "Number", "Security Code", "Expiration Date", "Initial Payment"};
	
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
			
			//Save Button
			if(event.getSource() == saveButton) {
				
				
				String[] dateOfBirth = textFields.get(1).getText().split("/");
				Date dob;
				try {
					dob = new Date(Integer.parseInt(dateOfBirth[0]), Integer.parseInt(dateOfBirth[1]), Integer.parseInt(dateOfBirth[2]));
					if(dob.getYear() >= 1999 && comboBoxes.get(0).getSelectedIndex() == 4) {
						System.out.println("Too young.");
						dispose();
					}
				}
				catch (Exception e) {
					dob = new Date();
				}
				String[] dateOfReservation = textFields.get(4).getText().split("/");
				String creditCardInformation = textFields.get(8).getText() + "\n" + textFields.get(8).getText() + "\n" + textFields.get(9).getText() + "\n" + textFields.get(10).getText();
				Date dor;
				try {
					dor = new Date(Integer.parseInt(dateOfReservation[0]), Integer.parseInt(dateOfReservation[1]), Integer.parseInt(dateOfReservation[2]));
				}
				catch (Exception e) {
					dor = new Date();
				}
				System.out.println(creditCardInformation);
				Guest g = new Guest(textFields.get(0).getText(), dob,textFields.get(2).getText(), textFields.get(6).getText(), creditCardInformation, dor, textFields.get(5).getText(), (String)comboBoxes.get(1).getSelectedItem(), textFields.get(8).getText());
				System.out.println(g);
				
				MealPlan mp = new MealPlan(comboBoxes.get(1).getSelectedIndex());
				
				FrontDeskAgent.addReservation(g, comboBoxes.get(0).getSelectedIndex(), mp);
				try {
					FrontDeskAgent.getReservations().get(FrontDeskAgent.getReservations().size()-1).getBaseRoom().updateCostOfAddOns(Double.parseDouble(textFields.get(12).getText())*-1);
					System.out.println(FrontDeskAgent.getReservations().get(FrontDeskAgent.getReservations().size()-1).getBaseRoom());
				} catch (Exception e) {
					System.out.println("Did not work!");
				}
				dispose();
				cancelButton.setText("Close");
			}
			
			
			//Cancel Button
			else if(event.getSource() == cancelButton) {
				dispose();
			}
			
		}
	
	}
	
}
