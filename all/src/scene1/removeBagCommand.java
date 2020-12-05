package scene1;
import scene2.*;


public class removeBagCommand implements Command {
	Place[] places;
	Player p;

	public removeBagCommand(Place[] places, Player p) {
		super();
		this.places = places;
		this.p = p;
	}

	@Override
	public void execute(String s) {
		places[p.getPosition()].remove(s, p);
	}

}
