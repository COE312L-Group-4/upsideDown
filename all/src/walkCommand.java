
public class walkCommand implements Command {
	Place [] places;
	Player p;
	
	public walkCommand(Place[] places, Player p) {
		this.places = places;
		this.p = p;
	}

	@Override
	public void execute(String s) {
		int old = p.getPosition();
		p.setPosition(places[p.getPosition()].walk(s));
		if(old != p.getPosition()) {
			System.out.println(places[p.getPosition()].getDescription());
		}
	}

}
