package scene2;

import scene1.*;

public class talkCommand implements Command {

	Place pla;

	public talkCommand(Place pla) {
		this.pla = pla;

	}

	@Override
	public void execute(String s) {
		pla.talkInPlace(s);
	}

}
