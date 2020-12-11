package scene1;

import scene2.*;

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
	public void use(Player p,String s) {
		if(s.toLowerCase().contains("jump")) {
			if (p.printStatus().toLowerCase().contains("healthy")) {
				System.out.println(
						"To be able to safely jump, point your phone screen up and tilt it to be able to balance yourself on the edge of the window");
				use = true;
			} else {
				System.out.println("I do not have enough power to do this.. I need to increase my health");
			}
		}else {
			System.out.println("You can't use this object with that command");
		}

	}

	@Override
	public void update(Message m) {
		if (use) {
			if (m.condition.toLowerCase().contains("jumped")) {
				System.out.println(
						"Jumping was not a very smart move..\nLuckily you managed to land in the house keeping room");
				p.setPosition(3);
				p.notifyObservers();
				System.out.println("You hurt your leg..");
				p.setHealth(p.getHealth() - 20);
				p.setScore(p.getScore() + 10);
				use = false;
			} else {
				System.out.println("You need to balance yourself!");

			}

		}

	}

}
