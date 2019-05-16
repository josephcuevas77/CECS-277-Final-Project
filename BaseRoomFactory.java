package FinalExam;

public abstract class BaseRoomFactory {

	public static final int MAX_AQUA_WORLD_ROOMS = 1;
	public static final int MAX_SMALL_PARTY_ROOMS = 10;
	public static final int MAX_MEDIUM_PARTY_ROOMS = 2;
	public static final int MAX_KARAOKE_LOUNGE = 10;
	public static final int MAX_ADULT_BILLIARDS_LOUNGE = 5;
	
	protected abstract BaseRoom createRoom(int num);
		
}
