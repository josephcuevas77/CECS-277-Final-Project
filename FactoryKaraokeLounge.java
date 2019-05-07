public class FactoryKaraokeLounge {
	public BaseRoom createRoom() {
		return new KaraokeLounge();
	}
}
