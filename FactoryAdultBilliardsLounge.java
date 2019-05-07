public class FactoryAdultBilliardsLounge {
	public BaseRoom createRoom() {
		return new KaraokeLounge();
	}
}
