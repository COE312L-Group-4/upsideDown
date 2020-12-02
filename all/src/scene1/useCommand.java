package scene1;

public class useCommand implements Command {
	Place [] places;
	Player p;
	
	
	public useCommand(Place[] places, Player p) {
		this.places = places;
		this.p = p;
	}


	@Override
	public void execute(String s) {
		places[p.getPosition()].useInPlace(s,p);
		
	}

}
