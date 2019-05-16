package FinalExam;

public class ConcreteRoomFactory extends BaseRoomFactory {

	public static String[] ROOMS = {"Aqua World", "Small Party Room", "Medium Party Room", "Karaoke Lounge", "Adult Billiards Lounge"};
	protected BaseRoom createRoom(int num) {
		switch(num) {
			case(0): //Aqua World
				return new AquaWorld();
			case(1): //Small Party Room
				return new SmallPartyRoom();
			case(2): //Medium Party Room
				return new MediumPartyRoom();
			case(3): //Karaoke Lounge
				return new KaraokeLounge();
			case(4): //Adult Billiards Lounge
				return new AdultsBilliardsLounge();
			default:
				return null;
			
		}
	}

}
