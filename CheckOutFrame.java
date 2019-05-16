package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckOutFrame extends JFrame{
	
	public static void main(String[] args) {
		CheckOutFrame f = new CheckOutFrame();
		f.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;

	private JButton button;
	private JList list;
	private JLabel label1;
	private JLabel label2;
	private JTextField textField1;
	private JTextField textField2;
	final private static int FRAME_WIDTH = 550;
	final private static int FRAME_HEIGHT = 500;
	
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<Guest> CheckedInGuests = new ArrayList<Guest>();
	
	
	
	public CheckOutFrame(){
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Check-Out Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ClickListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {
				for (Reservation r : FrontDeskAgent.getReservations()) {
					if (r.getGuest().equals(CheckedInGuests.get(list.getSelectedIndex()))) {
						try {
						r.getBaseRoom().updateCostOfAddOns(Integer.parseInt(label1.getText()));
						r.getBaseRoom().updateDescriptionOfAddOns(label2.getText());
						} 
						catch (Exception e) {}
					}
				}
			}
		}
	}
	
	public void createComponents() {
		
		ActionListener listener = new ClickListener();
		JPanel panel = new JPanel();
		
		for (Reservation r : FrontDeskAgent.getReservations()) {
			if (r.getGuest().getCheckInStatus()) {
				CheckedInGuests.add(r.getGuest());
			}
		}
		
		list = new JList(CheckedInGuests.toArray());
		list.setVisible(true);
		panel.add(list);
		
		label1 = new JLabel("Additional Damage Charges: ");
		label2 = new JLabel("Damage Description: ");
		textField1 = new JTextField(25);
		textField2 = new JTextField(25);
		panel.add(label1);
		panel.add(textField1);
		panel.add(label2);
		panel.add(textField2);
		
		button = new JButton("Finalize");
		button.addActionListener(listener);
		buttons.add(button);
		panel.add(button);
		
		add(panel);
	}
}