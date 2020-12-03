package scene2;

import scene1.*;

public class GunFight extends FightStrategy {
	boolean fight;
	Player p;
	boolean gun;
	private TCP_Client tcp;
	int updateCount;

	public GunFight(Player p, TCP_Client subject) {
		this.p = p;
		this.gun = false;
		this.fight = false;
		this.tcp = subject;
		this.tcp.registerObserver(this);
		updateCount = 0;
	}

	@Override
	public void fight() {
		fight = true;
		for (int i = 0; i < p.bag.size(); i++) {
			if (p.bag.get(i).name.contains("gun")) {
				System.out.println("Use the sensor now..");
				gun = true;
			}
		}
		if (gun) {

		} else {
			System.out.println("I forgot my gun in the car!");
		}
	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint,
			String act) {
		if (fight && gun) {
			if (Orint == 3 || Orint == 4) {
				updateCount++;
				if (updateCount > 5) {
					System.out.println("I am hurt by gun");
					fight = false;
				}
			}
		}

	}
}
