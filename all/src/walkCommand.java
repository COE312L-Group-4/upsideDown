
public class walkCommand implements Command {
	Place[] places;
	Player p;

	public walkCommand(Place[] places, Player p) {
		this.places = places;
		this.p = p;
	}

	@Override
	public void execute(String s) {
		int old = p.getPosition();
		int x = places[p.getPosition()].walk(s);
		if (places[x].isOpen() && places[old].isOpen()) {
			p.setPosition(x);
			if (old != p.getPosition()) {
				System.out.println(places[p.getPosition()].getDescription());
				p.notifyObservers();
			}
		} else {
			System.out.println("This room is locked, You need to find a way to open it !!");
		}
	}

}
