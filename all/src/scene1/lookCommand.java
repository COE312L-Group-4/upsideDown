package scene1;

import scene2.*;

public class lookCommand implements Command {
	Place s;
	
	public lookCommand(Place s) {
		this.s = s;
	}

	@Override
	public void execute(String str) {
		this.s.look();
	}

}
