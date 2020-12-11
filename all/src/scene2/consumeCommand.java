package scene2;

import scene1.*;

public class consumeCommand implements Command {
	Place pla;

	public consumeCommand(Place pla) {
		this.pla = pla;
	}

	@Override
	public void execute(String s) {
		pla.useInPlace(s);
	}

}
