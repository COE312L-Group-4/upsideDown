package scene2;

import scene1.*;

public class GunFight extends FightStrategy {
	Player p;
	boolean gun;
	boolean fight;
	// private TCP_Client tcp;
	int updateCount;

	public GunFight(Player p, TCP_Client subject) {
		super(subject);
		this.p = p;
		this.gun = false;
		this.fight = false;
		// this.tcp = subject;
		updateCount = 0;
	}

	@Override
	public void fight() {
		if (gun) {
			if (p.printStatus().toLowerCase().contains("healthy")) {

				fight = true;
				System.out.println(
						"Place your phone pointing to the moitor with the Phone screen pointing on one of the sides \nto threaten Haro Sato with the Gun");
			} else {
				System.out.println("I do not have enough power to do this.. I need to increase my health");
			}
		}
	}

	@Override
	public void update(Message m) {
		if (gun && fight) {
			if (m.condition.toLowerCase().contains("gunwon")) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("You are pointing your gun at Haru Sato, he seems to be close to confess!");
				} else {
					fight = false;
					p.setHealth(p.getHealth() - 20);
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
