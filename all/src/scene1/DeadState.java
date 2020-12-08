package scene1;

public class DeadState implements State {

	@Override
	public void prev(Player context) {
		//System.out.println("You are dead you can't return to any state");
	}

	@Override
	public void next(Player context) {
		//System.out.println("You are dead you can't go to any state");
	}

	@Override
	public String printStatus(Player context) {
		return("I'm dead ..pray for me.. health = " + context.getHealth() + "/100!");

	}

}
