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
		this.p=p;
	}

	@Override
	public void fight() {
		hand = true;
		System.out.println(
				"Move your phone forward and backward with the screen facing up to punch haru sato repeatedly");

	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint) {
		if (hand) {
			if ((accy >= 0.2)) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("I am hurt by hand");
				} else {
					hand = false;
					p.setHealth(p.getHealth()-30);
					Confess(p);

				}
			}
		}
	}

	@Override
	public void checkItem() {

	}
}
