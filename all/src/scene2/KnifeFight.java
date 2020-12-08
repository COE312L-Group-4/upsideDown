package scene2;

import scene1.*;
import scene1.Object;

public class KnifeFight extends FightStrategy {
	boolean knife;
	// private TCP_Client tcp;
	int updateCount;
	Player p;

	public KnifeFight(TCP_Client tcp, Player p) {
		super(tcp);
		// this.tcp = tcp;
		// this.tcp.registerObserver(this);
		this.knife = false;
		this.updateCount = 0;
		this.p = p;
	}

	@Override
	public void fight() {
		if (p.printStatus().toLowerCase().contains("healthy")) {
			knife = true;
			System.out.println("Place the phone screen up while moving the phone diagonally to use the knife");
		} else {
			System.out.println("I do not have enough power to do this.. I need to increase my health");
		}
	}

	@Override
	public void update(Message m) {
		if (knife) {
			if ((m.condition.toLowerCase().contains("knifewon"))) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("You are swinging the knife at Haru Sato's. He is close to confessing!");
				} else {
					knife = false;
					p.setHealth(p.getHealth() - 30);
					Confess(p);
				}

			}
		}
	}

	public void checkItem() {

	}

}
