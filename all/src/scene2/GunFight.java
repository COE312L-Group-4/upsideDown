package scene2;

import scene1.*;

public class GunFight extends FightStrategy {
	Player p;
	boolean gun;
	boolean fight;
	//private TCP_Client tcp;
	int updateCount;

	public GunFight(Player p, TCP_Client subject) {
		super(subject);
		this.p = p;
		this.gun = false;
		this.fight = false;
		//this.tcp = subject;
		updateCount = 0;
	}

	@Override
	public void fight() {
		if (gun) {
			fight = true;
			System.out.println(
					"Place your phone pointing to the moitor with the Phone screen pointing on one of the sides to threaten Haro Satos with the Gun");
			p.setHealth(p.getHealth()-20);

		}
	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint) {
		if (gun && fight) {
			if (Orint == 3 || Orint == 4) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("I am hurt by gun");
				} else {
					fight = false;
					Confess(p);
				}
			}
		}

	}

	public void checkItem() {
		for (int i = 0; i < p.bag.size(); i++) {
			if (p.bag.get(i).name.contains("gun")) {
				gun = true;
				return;
			}
		}
		System.out.println("Ohhh You forgot your gun in the car, You can't fight using the Gun, try another weapon!");
	}

	@Override
	public boolean ItemNeeded() {
		return true;
	}
}
