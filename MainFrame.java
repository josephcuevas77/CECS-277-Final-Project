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
	
	/**
	 * Description Menu, PartyRoomsSubMenu, LoungesSubMenu
	 * Reservations Menu, NewRes, EditRes, LoungesSubMenu
	 */
	
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
	private ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
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
		
//		submenus.add(new JMenu("Party Rooms"));
//		for (String s : rooms) {
//			System.out.println(s);
//			menuItem = new JMenuItem(s);
//			menuItem.addActionListener(listener);
//			submenus.get(0).add(menuItem);
//			
//		}
//		menu.add(submenus.get(0));
//		
//		submenus.add(new JMenu("Lounges"));
//		for (String s : lounges) {
//			menuItem = new JMenuItem(s);
//			menuItem.addActionListener(listener);
//			submenus.get(1).add(menuItem);
//		}
//		menu.add(submenus.get(1));
//		
//		submenus.add(new JMenu("Meal Plans"));
//		for (String s : meals) {
//			menuItem = new JMenuItem(s);
//			menuItem.addActionListener(listener);
//			submenus.get(2).add(menuItem);
//		}
//		menu.add(submenus.get(1));
//		
//		menuBar.add(menu);
//		
//		menu = new JMenu("Reservations");
//		
//		menuItem = new JMenuItem("New Reservation");
//		menuItem.addActionListener(listener);
//		menuItems.add(menuItem);
//		menu.add(menuItem);
//		
//		menuItem = new JMenuItem("Edit Reservation");
//		menuItem.addActionListener(listener);
//		menuItems.add(menuItem);
//		menu.add(menuItem);
//
//		submenus.add(new JMenu("Manage Current Reservations"));
//		menuItem = new JMenuItem("Check-in");
//		menuItem.addActionListener(listener);
//		menuItems.add(menuItem);
//		submenus.get(1).add(menuItem);
//		
//		menuItem = new JMenuItem("Check-out");
//		menuItem.addActionListener(listener);
//		menuItems.add(menuItem);
//		submenus.get(1).add(menuItem);
//		
//		menu.add(submenus.get(1));
//		
//		menuBar.add(menu);
//
		panel.add(mainMenuBar);
		add(panel);
		
	}
	
	class ClickListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == partyRoomDescriptionSubMenu.getItem(0)) {
				System.out.println("All button from partyRoomDescriptionSubMenu");
			}
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(1)) {
				System.out.println("Small Party Rooms button from partyRoomDescriptionSubMenu");
			}
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(2)) {
				System.out.println("Medium Party Rooms button from partyRoomDescriptionSubMenu");
			}
			else if (event.getSource() == partyRoomDescriptionSubMenu.getItem(3)) {
				System.out.println("Aqua World button from partyRoomDescriptionSubMenu");
			}
		}	
	}
}
