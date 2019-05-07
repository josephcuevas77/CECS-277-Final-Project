public class FactoryAquaWorld {
	/**
	 * createRoom function which returns the room as a BaseRoom
	*/
	public BaseRoom createRoom() {
		return new AquaWorld();
	}
}
