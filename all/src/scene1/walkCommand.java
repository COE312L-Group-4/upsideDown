package scene1;
import scene2.*;


public class walkCommand implements Command {
	Place pla;
	public walkCommand(Place pla) {
		this.pla = pla;
	}

	@Override
	public void execute(String s) {
		pla.walk(s);
		/*int old = p.getPosition();
		int x = pla.walk(s);
		if (places[x].isOpen() && places[old].isOpen()) {
			p.setPosition(x);
			if (old != p.getPosition()) {
				System.out.println(places[p.getPosition()].getDescription());
				p.notifyObservers();
			}
		} else {
			System.out.println("This room is locked, You need to find a way to open it!!");
		}*/
	}

}
//position as an obj ref to location