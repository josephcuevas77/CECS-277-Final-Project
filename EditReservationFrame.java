package FinalExam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditReservationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JCheckBox checkBox; 
	private JComboBox<String> comboBox;
	private JButton button;
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JPanel panel7 = new JPanel();
	private JPanel panel8 = new JPanel();
	private JPanel panel9 = new JPanel();
	private JPanel panel0 = new JPanel();
	private JPanel panel01 = new JPanel();

	final private static int FRAME_WIDTH = 1920;
	final private static int FRAME_HEIGHT = 540;

	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private ArrayList<JComboBox<String>> comboBoxes = new ArrayList<JComboBox<String>>();
	
	private String[] guestInfo = {"Name", "Phone Number", "Address", "Date of Birth", "Email", "Address"};
	private String[] creditCard = {"Name", "Number", "Security Code", "Expiration Date"};

	public EditReservationFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Edit Reservation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {
				String confirmNumOrGN = fields.get(0).getText();
				for (Reservation r : FrontDeskAgent.getReservations()) {
					if(confirmNumOrGN.equals(r.getGuest().getName()) || confirmNumOrGN.equals(Integer.toString(r.getConfirmNum()))){
						createButtonIntoPanel("Delete Reservation",panel01);
						panel1.setVisible(true);	panel2.setVisible(true);
						panel3.setVisible(true);	panel4.setVisible(true);
						panel5.setVisible(true);	panel6.setVisible(true);
						panel7.setVisible(true);	panel8.setVisible(true);
						panel9.setVisible(true);	panel0.setVisible(true);
						panel01.setVisible(true);
					}
				}
				for(Reservation r: FrontDeskAgent.getWaitList()) {
					if(confirmNumOrGN.equals(Integer.toString(r.getConfirmNum()))){
						createButtonIntoPanel("Delete Reservation",panel01);
						panel1.setVisible(true);	panel2.setVisible(true);
						panel3.setVisible(true);	panel4.setVisible(true);
						panel5.setVisible(true);	panel6.setVisible(true);
						panel7.setVisible(true);	panel8.setVisible(true);
						panel9.setVisible(true);	panel0.setVisible(true);
						panel01.setVisible(true);
					}
				}
			}
			if(event.getSource() == buttons.get(1)) {
				for (Guest g : FrontDeskAgent.getGuests()) {
					for(Reservation r: FrontDeskAgent.getWaitList()) {
						if(g.getDate().equals(r.getGuest().getDate())){
							createNotifyGuestFrame(r.getGuest());
							FrontDeskAgent.getGuests().remove(g);
						}
					}
				}
			}
		}
	}

	public void createLabel(String lab, JPanel panel) {
		ActionListener listener = new ClickListener();
		JLabel label = new JLabel(lab);
		labels.add(label);
		panel.add(label);
	}

	public void createComponents() {
		ActionListener listener = new ClickListener();
		createLabelAndTextField("Enter Confirmation Number/Guest Name: ",panel);
		createButtonIntoPanel("Confirm",panel);
		panel1.add(new JLabel("Guest Information: "));
		for (int i=0; i<guestInfo.length; i++) {
			createText(guestInfo[i], panel1);
		}
		
		panel2.add(new JLabel("Credit Card Information: "));
		for (int i=0; i<creditCard.length; i++) {
			createText(creditCard[i], panel2);
		}
		
		checkBox = new JCheckBox("Contact via Phone"); 
		panel3.add(checkBox);
		checkBox = new JCheckBox("Contact via Email"); 
		panel3.add(checkBox);
		
		createComboBox(ConcreteRoomFactory.ROOMS, "Rooms: ", panel4, comboBoxes);
		createComboBox(MealPlan.mealPlans, "Meal Plans: ", panel4, comboBoxes);
		createComboBox(MealPlan.pizzaToppings, "Pizza Toppings: ", panel5, comboBoxes);
		createComboBox(MealPlan.sodaBottles, "Soda Choices: ", panel5, comboBoxes);
		createComboBox(MealPlan.iceCreamFlavors, "Ice Cream Flavors: ", panel6, comboBoxes);
		createComboBox(MealPlan.wingFlavors, "Wing Flavors: ", panel6, comboBoxes);


		panel7.add(new JLabel("Room: "));
		comboBox = new JComboBox<String>(ConcreteRoomFactory.ROOMS);
		panel7.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.mealPlans);
		panel8.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.pizzaToppings);
		panel8.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.sodaBottles);
		panel9.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.iceCreamFlavors);
		panel9.add(comboBox);
		comboBox = new JComboBox<String>(MealPlan.wingFlavors);
		panel0.add(comboBox);
		
		button = new JButton("Save");
		panel01.add(button);
		button = new JButton("Cancel");
		panel01.add(button);
		
		panel1.setVisible(false);	panel2.setVisible(false);
		panel3.setVisible(false);	panel4.setVisible(false);
		panel5.setVisible(false);	panel6.setVisible(false);
		panel7.setVisible(false);	panel8.setVisible(false);
		panel9.setVisible(false);	panel0.setVisible(false);
		panel01.setVisible(false);
		
		panel.add(panel1);	panel.add(panel2);	panel.add(panel3);
		panel.add(panel4);	panel.add(panel5);	panel.add(panel6);
		panel.add(panel7);	panel.add(panel8);	panel.add(panel9);
		panel.add(panel0);	panel.add(panel01);
		add(panel);
		
	}

	public void createNotifyGuestFrame(Guest g) {
		JFrame notifyGuest = new JFrame();
		JPanel panel = new JPanel();
		createLabel("Now notifying waitlisted guest " + g.getName() + " of confirmed reservation...", panel);
		notifyGuest.setTitle("Notify Waitlist Guest");
		notifyGuest.setSize(500,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		notifyGuest.add(panel);
		notifyGuest.setVisible(true);
	}

	public void createLabelAndTextField(String lab, JPanel panel) {
		ActionListener listener = new ClickListener();
		JLabel label = new JLabel(lab);
		labels.add(label);
		panel.add(label);
		JTextField field = new JTextField(20);
		fields.add(field);
		panel.add(field);
	}

	public void createButtonIntoPanel(String butt, JPanel panel) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	public JComboBox<String> createComboBox(String[] options, String title, JPanel panel, ArrayList<JComboBox<String>> comboList) {
		createLabel(title, panel);
		JComboBox<String> comboBox = new JComboBox<String>(options);
		comboList.add(comboBox);
		panel.add(comboBox);
		return comboBox;
	}
	
	public void createText(String s, JPanel p) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(s);
		JTextField textField = new JTextField(20);
		panel.add(label);
		panel.add(textField);
		p.add(panel);
	}
}
