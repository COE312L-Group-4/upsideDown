package scene1;
import scene2.*;

public class bagCommand implements Command {

	Player p;

	public bagCommand(Player p) {
		this.p = p;
	}

	@Override
	public void execute(String s) {
		p.getBagContent();
	}

}
