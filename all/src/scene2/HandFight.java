package scene2;

import scene1.*;

public class HandFight extends FightStrategy {
	boolean hand;
	int updateCount;
	Player p;

	public HandFight(TCP_Client tcp, Player p) {
		super(tcp);
		this.hand = false;
		this.updateCount = 0;
		this.p = p;
	}

	@Override
	public void fight() {
		if (p.printStatus().toLowerCase().contains("healthy")) {
			hand = true;
			System.out.println(
					"Move your phone forward and backward with the screen facing up to punch haru sato repeatedly");
		} else {
			System.out.println("I do not have enough power to do this.. I need to increase my health");
		}
	}

	@Override
	public void update(Message m) {
		if (hand) {
			if ((m.condition.toLowerCase().contains("handwon"))) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("You are punching Haru Sato. He will confess soon!");
				} else {
					hand = false;
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
