package scene1;

import scene2.*;

public class removeBagCommand implements Command {
	Place pla;

	public removeBagCommand(Place pla) {
		super();
		this.pla = pla;
	}

	@Override
	public void execute(String s) {
		pla.remove(s);
	}

}
