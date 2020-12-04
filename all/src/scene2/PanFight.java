package scene2;

import scene1.*;

public class PanFight extends FightStrategy {
	boolean pan;
	TCP_Client tcp;
	int updateCount;
	Player p;

	public PanFight(TCP_Client tcp, Player p) {
		super();
		pan = false;
		this.tcp = tcp;
		this.tcp.registerObserver(this);
		updateCount = 0;
		this.p = p;
	}

	public void fight() {
		pan = true;
		System.out.println(
				"Move your phone up and down as fast as you can while maintaing the screen of your phone facing up to hit Haru Sato on his head with the pan...");

	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int OrintF) {
		if (pan) {
			if ((accy >= 0.1 || accy <= -0.1) && (accz <= -0.5) && (gyrx >= 0.6 || gyrx <= -0.3)) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("I am hurt by Pan");
				} else {
					// Confess(p);
					pan = false;
				}
			}
		}
	}

	@Override
	public void checkItem() {

	}
}
