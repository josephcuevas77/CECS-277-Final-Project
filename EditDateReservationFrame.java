package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.*;


public class EditDateReservationFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	private JList list = new JList(FrontDeskAgent.getReservations().toArray());
	private JSpinner monthSpin = new JSpinner();
	private JSpinner daySpin= new JSpinner();
	private JSpinner yearSpin= new JSpinner();
	private JButton confirmButton = new JButton("Confirm");
	private ActionListener listener = new ClickListener();
	private JButton cancelButton = new JButton("Cancel");
	final private static int FRAME_WIDTH = 550;
	final private static int FRAME_HEIGHT = 500;
	
	ArrayList<Guest> CheckedInGuests = new ArrayList<Guest>();
	
	
	
	public EditDateReservationFrame(){
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Edit Date of Reservation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	class ClickListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == confirmButton) {
				if((int)monthSpin.getValue()!=0 && (int)daySpin.getValue()!=0 && (int)yearSpin.getValue()!=0) {
					dispose();
				}
					Date date  = FrontDeskAgent.getReservations().get(list.getSelectedIndex()).getGuest().getDate();
					System.out.println(date);
//					monthSpin = new JSpinner(new SpinnerNumberModel(date.getMonth(), 0, 3000, 1));
//					daySpin = new JSpinner(new SpinnerNumberModel(date.getDay(), 0, 3000, 1));
//					yearSpin = new JSpinner(new SpinnerNumberModel(date.getYear(), 0, 3000, 1));
					monthSpin.setValue(date.getMonth());
					daySpin.setValue(date.getDay());
					yearSpin.setValue(date.getYear());
			}
		}
	}
	
	public void createComponents() {
		
		JPanel panel = new JPanel();
	
		confirmButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
		
		
		panel.add(list);
		panel.add(new JLabel("Month: "));
		panel.add(monthSpin);
		panel.add(new JLabel("Day: "));
		panel.add(daySpin);
		panel.add(new JLabel("Year: "));
		panel.add(yearSpin);
		panel.add(confirmButton);
		panel.add(cancelButton);
		
		add(panel);
	}
}
