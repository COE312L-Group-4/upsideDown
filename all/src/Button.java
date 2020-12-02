
public class Button extends Object {

	public Button(String color) {
		super("exit button", color, "Button", false);

	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use(Player p) {	
		for (int i = 0; i < p.bag.size(); i++) {
			if (p.bag.get(i).name.contains("car keys")) {
				p.setPosition(0);
				System.out.println("You have entered your car");
				return;
			} else {
				System.out.println("You cannot exit the hotel before collecting enough evidence!");
			}
		}
	}

}
