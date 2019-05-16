package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class WaitlistMessageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<JTextField> fields = new ArrayList<JTextField>();
	ArrayList<JLabel> labels = new ArrayList<JLabel>();

	public WaitlistMessageFrame() {
		createComponents();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setTitle("Waitlist Message");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void createComponents() {
		ActionListener listener = new ClickListener();
		createLabel("No availability on selected date/time. Add to waitlist?",panel);
		createButtonIntoPanel("Accept",panel1);
		createButtonIntoPanel("Decline",panel);
	}

	class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == buttons.get(0)) {
				JFrame nR = new NewReservationFrame(); 
				Reservation r = FrontDeskAgent.getReservations().get(FrontDeskAgent.getReservations().size() - 1);
				FrontDeskAgent.addToWaitlist(r);
			}
			else if (event.getSource() == buttons.get(1)) {
				JFrame nR = new SelectDateTimeFrame();
			}

		}
	}

	public JLabel createLabel(String title, JPanel panel) {
		JLabel label = new JLabel(title);
		panel.add(label);
		return label;
	}

	public void createButtonIntoPanel(String butt, JPanel panel) {
		ActionListener listener = new ClickListener();
		JButton button = new JButton(butt);
		buttons.add(button);
		button.addActionListener(listener);
		panel.add(button);
	}
}


