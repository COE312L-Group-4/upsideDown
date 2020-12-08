package scene1;

import scene2.*;

public class FireExtinguisher extends Object {

	boolean use;
	private TCP_Client subject;
	Place sr;
	Player p;
	public FireExtinguisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FireExtinguisher(String color, TCP_Client subject, Place sr,Player p) {
		super("fire extinguisher", color, "A fire extinguisher at the end of the hallway", false);
		this.subject = subject;
		subject.registerObserver(this);
		this.sr = sr;
		this.p = p;
		use = false;
	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use(Player p) {
		if (!sr.isOpen()) {
			if (p.printStatus().toLowerCase().contains("healthy")) {
				System.out.println("You can use the fire extinguisher to break the lock on the security room door!");
				System.out.println("Make your phone face the wall then move your phone up and down as fast as you can");
				use = true;
			} else {
				System.out.println("I do not have enough power to do this.. I need to increase my health");
			}
		} else {
			System.out.println("The door is already open!");
		}
	}

	@Override
	public void update(Message m) {
		if (use && !sr.isOpen()) {
			if ((m.condition.toLowerCase().contains("broke"))) {
				System.out.println("You broke the door of the security room you can now access it!");
				p.setHealth(p.getHealth() - 10);
				p.setScore(p.getScore() + 10);
				sr.setOpen(true);
				use = false;
			} else {
				System.out.println("You need to try harder");
			}

		}
	}

}
