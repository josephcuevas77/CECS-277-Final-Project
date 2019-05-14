package FinalExam;

public abstract class BaseRoomFactory {

	public static final int MAX_AQUA_WORLD_ROOMS = 1;
	public static final int SMALL_PARTY_ROOMS = 10;
	public static final int MEDIUM_PARTY_ROOMS = 2;
	public static final int KARAOKE_LOUNGE = 10;
	public static final int ADULT_BILLIARDS_LOUNGE = 5;
	
	public abstract BaseRoom createRoom(int num);
		
}
