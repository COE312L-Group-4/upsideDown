package scene2;

import scene1.*;

public class PanFight extends FightStrategy {
	boolean pan;
	// TCP_Client tcp;
	int updateCount;
	Player p;

	public PanFight(TCP_Client tcp, Player p) {
		super(tcp);
		pan = false;
		// this.tcp = tcp;
		// this.tcp.registerObserver(this);
		updateCount = 0;
		this.p = p;
	}

	public void fight() {
		if (p.printStatus().toLowerCase().contains("healthy")) {
			pan = true;
			System.out.println(
					"Move your phone up and down as fast as you can while maintaing the screen of your phone facing up to hit Haru Sato on his head with the pan...");
		} else {
			System.out.println("I do not have enough power to do this.. I need to increase my health");
		}
	}

	@Override
	public void update(Message m) {
		if (pan) {
			if ((m.condition.toLowerCase().contains("panwon"))) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("You are hitting Haru Sato's head with the pan. He is about to confess!");
				} else {
					pan = false;
					p.setHealth(p.getHealth() - 30);
					Confess(p);
				}

			}
		}
	}

	@Override
	public void checkItem() {

	}
}
