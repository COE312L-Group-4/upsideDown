package scene1;

import scene2.*;

public class storeCommand implements Command {
	Place pla;

	public storeCommand(Place pla) {
		this.pla = pla;
	}

	@Override
	public void execute(String s) {
		pla.store(s);
	}

}
