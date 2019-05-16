package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	private JMenuBar mainMenuBar = new JMenuBar();
	private JMenu descriptionMenu = new JMenu("Descriptions");
	private JMenu reservationsMenu = new JMenu("Reservations");
	private JMenu partyRoomDescriptionSubMenu = new JMenu("Party Rooms");
	private JMenu loungesDescriptionSubMenu = new JMenu("Lounges");
	private JMenu manageReservationSubMenu = new JMenu("Manage Current Reservation");
	
	private JMenuItem menuItem;
	private JPanel panel = new JPanel();
	private String[] rooms = {"All", "Small Party Rooms", "Medium Party Rooms", "Aqua Room"};
	private String[] lounges = {"All", "Karaoke Lounge", "Adult Billiards Lounge"};
	private String[] meals = {"All", "Bronze", "etc."};
	
	public MainFrame() {
		createComponents();
		FrontDeskAgent.generateAllRooms();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createComponents() {
		
		ActionListener listener = new ClickListener();
		mainMenuBar.add(descriptionMenu);
		mainMenuBar.add(reservationsMenu);
		
		descriptionMenu.add(partyRoomDescriptionSubMenu);
		descriptionMenu.add(loungesDescriptionSubMenu);
		
		menuItem = new JMenuItem("New Reservation");
		menuItem.addActionListener(listener);
		reservationsMenu.add(menuItem);
		menuItem = new JMenuItem("Edit Reservation");
		menuItem.addActionListener(listener);
		reservationsMenu.add(menuItem);

		menuItem = new JMenuItem("Check-in");
		menuItem.addActionListener(listener);
		manageReservationSubMenu.add(menuItem);
		
		menuItem = new JMenuItem("Check-out");
		menuItem.addActionListener(listener);
		manageReservationSubMenu.add(menuItem);
		
		
		reservationsMenu.add(manageReservationSubMenu);
		
		for(String s: rooms) {
			menuItem = new JMenuItem(s);
			menuItem.addActionListener(listener);
			partyRoomDescriptionSubMenu.add(menuItem);
		}
		
		for(String s: lounges) {
			menuItem = new JMenuItem(s);
			menuItem.addActionListener(listener);
			loungesDescriptionSubMenu.add(menuItem);
		}
		
		panel.add(mainMenuBar);
		add(panel);
		
	}
	
	class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			//All button from partyRoomDescriptionSubMenu
			if (event.getSource() == partyRoomDescriptionSubMenu.getItem(0)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				SmallPartyRoom s = new SmallPartyRoom();
				MediumPartyRoom m = new MediumPartyRoom();
				AquaWorld a = new AquaWorld();
				textArea.setText("Small Party Room: " + s.getDescription() + "\nMedium Party Room: " + m.getDescription() + 
						"\nAquaWorld Room: " + a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(600, 200);
				frame.setTitle("Main Menu");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			//Small Party Rooms button from partyRoomDescriptionSubMenu
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(1)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				SmallPartyRoom a = new SmallPartyRoom();
				textArea.setText(a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setSize(600, 200);
				frame.setTitle("Small Party Room");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			//Medium Party Rooms button from partyRoomDescriptionSubMenu
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(2)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				MediumPartyRoom a = new MediumPartyRoom();
				textArea.setText(a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);	
				frame.setSize(600, 200);			
				frame.setTitle("Medium Party Room");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			//Aqua World button from partyRoomDescriptionSubMenu
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(3)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				AquaWorld a = new AquaWorld();
				textArea.setText(a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setSize(600, 200);
				frame.setTitle("Aqua World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			//All lounge descriptions from loungesDescriptionSubMenu
			if (event.getSource() == loungesDescriptionSubMenu.getItem(0)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				KaraokeLounge k = new KaraokeLounge();
				AdultsBilliardsLounge a = new AdultsBilliardsLounge();
				textArea.setText("Karaoke Lounge: " + k.getDescription() + "\nAdult Billiards Lounge: " + a.getDescription());
		        frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setSize(600, 200);
				frame.setTitle("Description of all lounges");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			//Karaoke Lounge button from loungesDescriptionSubMenu
			else if (event.getSource() == loungesDescriptionSubMenu.getItem(1)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				KaraokeLounge k = new KaraokeLounge();
				textArea.setText("Karaoke Lounge: " + k.getDescription());
		        frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setSize(600, 200);
				frame.setTitle("Karaoke Lounge Description");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			//Adult Billiards Lounge button from loungesDescriptionSubMenu
			else if (event.getSource() == loungesDescriptionSubMenu.getItem(2)) {
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				AdultsBilliardsLounge a = new AdultsBilliardsLounge();
				textArea.setText("Adult Billiards Lounge: " + a.getDescription());
		        frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setSize(600, 200);
				frame.setTitle("Adult Billiards Lounge Description");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
			}
			//Check-in from MainFrame
			if (event.getSource() == manageReservationSubMenu.getItem(0)) {
				System.out.println("Check-in from MainFrame");
				CheckInFrame f = new CheckInFrame();
				f.setVisible(true);
			}
			//Check-out from MainFrame
			else if (event.getSource() == manageReservationSubMenu.getItem(1)) {
				System.out.println("Check-out from MainFrame");
				CheckOutFrame f = new CheckOutFrame();
				f.setVisible(true);
			}
			
			//New Reservation
			if (event.getSource() == reservationsMenu.getItem(0)) {
				System.out.println("New Reservation");
				NewReservationFrame f = new NewReservationFrame();
				f.setVisible(true);
			}
			//Edit
			else if (event.getSource() == reservationsMenu.getItem(1)) {
				System.out.println("Edit Reservation");
//				EditReservationFrame f = new EditReservationFrame();
//				f.setVisible(true);
				for(Reservation r: FrontDeskAgent.reservations) System.out.println(r);
			}
		}	
	}
}