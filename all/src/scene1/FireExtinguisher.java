package scene1;

import scene2.*;

public class FireExtinguisher extends Object {

	boolean use;
	private TCP_Client subject;
	Place sr;

	public FireExtinguisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FireExtinguisher(String color, TCP_Client subject, Place sr) {
		super("fire extinguisher", color, "A fire extinguisher at the end of the hallway", false);
		this.subject = subject;
		subject.registerObserver(this);
		this.sr = sr;
		use = false;
	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use(Player p) {
		if (!sr.isOpen()) {
			System.out.println("You can use the fire extinguisher to break the lock on the security room door!");
			System.out.println("Make your phone face the wall then move your phone up and down as fast as you can");
			use = true;
		} else {
			System.out.println("The door is already open!");
		}
	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz) {
		if (use && !sr.isOpen()) {
			if ((accy >= 0.2 || accy <= -0.2) && (accz <= -0.6 || accz >= 0.2)) {
				System.out.println("You broke the door of the security room you can now access it!");
				sr.setOpen(true);
				use = false;
			} else {
				System.out.println("You need to try harder");
			}
		}
	}

}
