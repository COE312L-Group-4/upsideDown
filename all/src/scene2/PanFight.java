package scene2;

import scene1.*;

public class PanFight extends FightStrategy {
	boolean pan;
	TCP_Client tcp;
	int updateCount;

	public PanFight(TCP_Client tcp) {
		super();
		pan = false;
		this.tcp = tcp;
		this.tcp.registerObserver(this);
		updateCount = 0;
	}

	public void fight() {
		pan = true;
		System.out.println("Use pan sensor now...");

	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint,
			String act) {
		if (pan) {
			if ((accy >= 0.1 || accy <= -0.1) && (accz <= -0.5) && (gyrx >= 0.6 || gyrx <= -0.3)) {
				updateCount++;
				if (updateCount < 5) {
					System.out.println("I am hurt by Pan");
				}else {
					pan = false;
				}
			}
		}
	}
}
