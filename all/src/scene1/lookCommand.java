package scene1;
import scene2.*;

public class lookCommand implements Command{
	Place [] places;
	Player p;

	
	public lookCommand(Place[] places, Player p) {
		this.places = places;
		this.p = p;
	}


	@Override
	public void execute(String s) {
		places[p.getPosition()].look();
	}

}
