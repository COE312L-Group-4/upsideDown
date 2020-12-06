package scene2;

import scene1.*;

public class talkCommand implements Command {
	
	
	Place[] places;
	Player p;

	public talkCommand(Place[] places, Player p) {
		this.places = places;
		this.p = p;

	}

	@Override
	public void execute(String s) {
		places[p.getPosition()].talkInPlace(s,p);		
	}

}
