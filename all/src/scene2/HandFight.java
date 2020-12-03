package scene2;

import scene1.*;

public class HandFight extends FightStrategy {
	boolean hand;
	private TCP_Client tcp;
	int updateCount;

	public HandFight(TCP_Client tcp) {
		super();
		this.tcp = tcp;
		this.tcp.registerObserver(this);
		this.hand = false;
		this.updateCount = 0;
	}

	@Override
	public void fight() {
		hand = true;
		System.out.println("Use hand sensor now...");
	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint,
			String act) {
		if (hand) {
			if (accy >= 1) {
				updateCount++;
				if (updateCount < 5) {
					System.out.println("I am hurt by hand");
				} else {
					hand = false;

				}
			}
		}
	}
}
