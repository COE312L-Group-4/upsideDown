package scene1;

public class HealthyState implements State {
	//boolean or if statement always false
	@Override
	public void prev(Player context) {
		//System.out.println("This is the root state");
	}

	@Override
	public void next(Player context) {
		if(context.getHealth() <=40) {
		context.setState(new WeakState());
		}
	}

	@Override
	public String printStatus(Player context) {
		return("You are in a healthy state, Your health is now = " + context.getHealth() + "/100!");

	}

}
