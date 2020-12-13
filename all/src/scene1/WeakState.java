package scene1;

public class WeakState implements State {

	@Override
	public void prev(Player context) {
		if (context.getHealth() > 40) {
			context.setState(new HealthyState());
		}
	}

	@Override
	public void next(Player context) {
		if (context.getHealth() <= 0) {
			context.setLoss(true);
			context.setState(new DeadState());

		}
	}

	@Override
	public String printStatus(Player context) {
		return("You are in the weak state, Health = " + context.getHealth() + "/100,  You won't be able to do heavy actions");

	}
	

}
