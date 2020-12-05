package scene1;
import scene2.*;


public class storeCommand implements Command {
	Place[] places;
	Player p;

	public storeCommand(Place[] places, Player p) {
		this.places = places;
		this.p = p;
	}

	@Override
	public void execute(String s) {
		places[p.getPosition()].store(s, p);
	}

}
