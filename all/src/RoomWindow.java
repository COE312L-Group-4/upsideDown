
public class RoomWindow extends Object {
	boolean use;
	private TCP_Client subject;
	Player p;

	public RoomWindow() {
		super();
	}

	public RoomWindow(String color, Player p, TCP_Client subject) {
		super("window", color,
				"The room has an open window that leads to the laundry room, and you can escape jumping from it",
				false);
		this.p = p;
		this.subject = subject;
		this.subject.registerObserver(this);

		use = false;
	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use(Player p) {
		System.out.println(
				"To be able to safely jump, point your phone screen up and tilt it to be able to balance yourself on the edge of the window");
		use = true;
	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz) {
		if (use && gyrx>=2) {
				System.out.println(
						"Jumping was not a very smart move..\nLuckily you managed to land in the Laundry room");
				p.setPosition(4);
				p.setHealth(p.getHealth() - 20);
				System.out.println("You hurt your leg.. your new health is " + p.getHealth() + "/100");
				p.setScore(p.getScore() + 10);
				use = false;
		}
	}

}
