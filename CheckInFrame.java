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

public class CheckInFrame extends JFrame {

	public static void main(String[] args) {
		CheckInFrame f = new CheckInFrame();
		f.setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;

	private JButton button;
	private JList list;
	private JLabel label;
	private JTextField textField;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<Guest> guests = new ArrayList<Guest>();
	private JPanel panel = new JPanel();
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	CheckInFrame() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Check-in Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createComponents() {
		ActionListener listener = new ClickListener();
		JPanel pan = new JPanel();
		label = new JLabel("Enter Date MM/DD/YYYY: ");
		textField = new JTextField(10);
		button = new JButton("Confirm Date");
		button.addActionListener(listener);
		buttons.add(button);
		pan.add(label);
		pan.add(textField);
		pan.add(button);
		panel.add(pan);
		
		list = new JList();
		list.setVisible(false);
		panel.add(list);
		
		button = new JButton("Check-in");
		button.addActionListener(listener);
		buttons.add(button);
		panel.add(button);
		
		button = new JButton("Cancel");
		button.addActionListener(listener);
		buttons.add(button);
		panel.add(button);
		
		add(panel);
	}
	
	class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == buttons.get(0)) {
				try {
					String[] stringDate = textField.getText().split("/");
					int[] date = new int[stringDate.length];
					for(int i = 0; i < stringDate.length; i++) date[i] = Integer.parseInt(stringDate[i]);
					Date d = new Date(date[0], date[1], date[2]);
	
					for (Reservation r : FrontDeskAgent.getReservations()) {
						if (r.getDate().equals(d)) {
							guests.add(r.getGuest());
						}
					}
					list.setListData(guests.toArray());
				}
				catch(Exception e) {}
				
				list.setVisible(false);
				list.setVisible(true);
			}
			if (event.getSource() == buttons.get(1)) {
				Guest g = guests.get(list.getSelectedIndex());
				FrontDeskAgent.checkIn(g);
				System.out.println(g);
				//FrontDeskAgent.checkIn(g);
			}
			if (event.getSource() == buttons.get(2)) {
				dispose();
			}
		}	
	}
}