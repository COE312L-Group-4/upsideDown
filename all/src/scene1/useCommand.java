package scene1;

import scene2.*;

public class useCommand implements Command {
	Place pla;

	public useCommand(Place pla) {
		this.pla = pla;
	}

	@Override
	public void execute(String s) {
		pla.useInPlace(s);

	}

}
