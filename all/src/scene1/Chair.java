package scene1;

public class Chair extends Object {

	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chair(String color) {
		super("chair", color, "There is a chair that you can use to block the door and prevent the security from reaching you", false);
	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use(Player p) {
	}

	public void use(Player p, Place place) {
		if (place.isOpen()) {
			place.setOpen(false);
			System.out.println("You used the chair to block the door.\nThe room is now locked");
		} else {
			place.setOpen(true);
			System.out.println("you removed the chair.\nThe room is now open");
		}
	}

}
