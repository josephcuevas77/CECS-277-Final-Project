package FinalExam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditReservationFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	final private static int FRAME_WIDTH = 800;
	final private static int FRAME_HEIGHT = 400;

	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	ArrayList<JLabel> labels = new ArrayList<JLabel>();

	JPanel panel2 = new JPanel();

	public EditReservationFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Edit Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == buttons.get(0)) {
				String confirmNumOrGN = fields.get(0).getText();
				for (Guest g : FrontDeskAgent.getGuests()) {
					if(confirmNumOrGN.contentEquals(g.getName())){
						panel2.add(new JLabel("Guest Information: "));
						createJTextArea(g.toString(),panel2);
						createButtonIntoPanel("Delete Reservation",panel2);
						panel2.setVisible(true);
					}
				}
				for(Reservation r: FrontDeskAgent.getWaitList()) {
					if(confirmNumOrGN.equals(Integer.toString(r.getConfirmNum()))){
						panel2.add(new JLabel("Guest Information: "));
						createJTextArea(r.getGuest().toString(),panel2);
						createButtonIntoPanel("Delete Reservation",panel2);
						panel2.setVisible(true);
						
					}
				}
			}
			if(event.getSource() == buttons.get(1)) {
				for (Guest g : FrontDeskAgent.getGuests()) {
					for(Reservation r: FrontDeskAgent.getWaitList()) {
						if(g.getDate().equals(r.getGuest().getDate()) && g.getTime().equals(r.getGuest().getTime())) {
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
		JPanel panel = new JPanel();
		createLabelAndTextField("Enter Confirmation Number/Guest Name: ",panel);
		createButtonIntoPanel("Confirm",panel);
		panel.add(panel2);
		panel2.setVisible(false);
		add(panel);
	}
	
	public void createJTextArea(String tArea,JPanel panel){
		JTextArea tA = new JTextArea();
		tA.setText(tArea);
		panel.add(tA);
	}

	public void createNotifyGuestFrame(Guest g) {
		JFrame notifyGuest = new JFrame();
		JPanel panel = new JPanel();
		createLabel("Now notifying waitlisted guest " + g.getName() + " of confirmed reservation...", panel);
		notifyGuest.setTitle("Notify Waitlist Guest");
		notifyGuest.setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notifyGuest.add(panel);
		notifyGuest.setVisible(true);
	}

	public void createLabelAndTextField(String lab, JPanel panel) {
		ActionListener listener = new ClickListener();
		JLabel label = new JLabel(lab);
		labels.add(label);
		panel.add(label);
		JTextField field = new JTextField(50);
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
}
