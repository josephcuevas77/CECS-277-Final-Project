package FinalExam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
	private JMenu partyRoomReservationSubMenu = new JMenu("Party Rooms");
	private JMenu loungesReservationSubMenu = new JMenu("Lounges");
	
	private JMenuItem menuItem;
	private JPanel panel = new JPanel();
	private String[] rooms = {"All", "Small Party Rooms", "Medium Party Rooms", "Aqua Room"};
	private String[] lounges = {"All", "Karaoke Lounge", "Adult Billiards Lounge"};
	private String[] meals = {"All", "Bronze", "etc."};
	
	public MainFrame() {
		createComponents();
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
		

		menuItem = new JMenuItem("Check-in");
		menuItem.addActionListener(listener);
		reservationsMenu.add(menuItem);
		
		menuItem = new JMenuItem("Check-out");
		menuItem.addActionListener(listener);
		reservationsMenu.add(menuItem);
		
		reservationsMenu.add(partyRoomReservationSubMenu);
		reservationsMenu.add(loungesReservationSubMenu);
		
		for(String s: rooms) {
			menuItem = new JMenuItem(s);
			menuItem.addActionListener(listener);
			partyRoomDescriptionSubMenu.add(menuItem);
			
			menuItem = new JMenuItem(s);
			menuItem.addActionListener(listener);
			partyRoomReservationSubMenu.add(menuItem);
		}
		
		
		
		for(String s: lounges) {
			menuItem = new JMenuItem(s);
			menuItem.addActionListener(listener);
			loungesDescriptionSubMenu.add(menuItem);

			menuItem = new JMenuItem(s);
			menuItem.addActionListener(listener);
			loungesReservationSubMenu.add(menuItem);
		}
		
		panel.add(mainMenuBar);
		add(panel);
		
	}
	
	class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == partyRoomDescriptionSubMenu.getItem(0)) {
				System.out.println("All button from partyRoomDescriptionSubMenu");
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				SmallPartyRoom s = new SmallPartyRoom();
				MediumPartyRoom m = new MediumPartyRoom();
				AquaWorld a = new AquaWorld();
				textArea.setText("Small Party Room: " + s.getDescription() + "\nMedium Party Room: " + m.getDescription() + 
						"\nAquaWorld Room: " + a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(600, 600);
				frame.setTitle("Main Menu");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(1)) {
				System.out.println("Small Party Rooms button from partyRoomDescriptionSubMenu");
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				SmallPartyRoom a = new SmallPartyRoom();
				textArea.setText(a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setTitle("Small Party Room");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(2)) {
				System.out.println("Medium Party Rooms button from partyRoomDescriptionSubMenu");
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				MediumPartyRoom a = new MediumPartyRoom();
				textArea.setText(a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);				
				frame.setTitle("Medium Party Room");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(3)) {
				System.out.println("Aqua World button from partyRoomDescriptionSubMenu");
				JFrame frame = new JFrame();
				JTextArea textArea = new JTextArea(); 
				AquaWorld a = new AquaWorld();
				textArea.setText(a.getDescription());
		        	frame.add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setTitle("Aqua World");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			if (event.getSource() == loungesDescriptionSubMenu.getItem(0)) {
				System.out.println("All button from loungesDescriptionSubMenu");
			}
			else if (event.getSource() == loungesDescriptionSubMenu.getItem(1)) {
				System.out.println("Karaoke Lounge button from loungesDescriptionSubMenu");
			}
			else if (event.getSource() == loungesDescriptionSubMenu.getItem(2)) {
				System.out.println("Adult Billiards Lounge button from loungesDescriptionSubMenu");
			}
			if (event.getSource() == reservationsMenu.getItem(0)) {
				System.out.println("Check-in from MainFrame");
			}
			else if (event.getSource() == reservationsMenu.getItem(1)) {
				System.out.println("Check-out from MainFrame");
			}
			
			if (event.getSource() == partyRoomReservationSubMenu.getItem(0)) {
				System.out.println("All button from partyRoomReservationSubMenu");
			}
			else if (event.getSource() == partyRoomReservationSubMenu.getItem(1)) {
				System.out.println("Small Party Rooms button from partyRoomReservationSubMenu");
			}
			else if (event.getSource() == partyRoomReservationSubMenu.getItem(2)) {
				System.out.println("Medium Party Rooms button from partyRoomReservationSubMenu");
			}
			else if (event.getSource() == partyRoomReservationSubMenu.getItem(3)) {
				System.out.println("Aqua World button from partyRoomReservationSubMenu");
			}
			if (event.getSource() == loungesReservationSubMenu.getItem(0)) {
				System.out.println("All button from loungesReservationSubMenu");
			}
			else if (event.getSource() == loungesReservationSubMenu.getItem(1)) {
				System.out.println("Karaoke Lounge button from loungesReservationSubMenu");
			}
			else if (event.getSource() == loungesReservationSubMenu.getItem(2)) {
				System.out.println("Adult Billiards Lounge button from loungesReservationSubMenu");
			}
		}	
	}
}
