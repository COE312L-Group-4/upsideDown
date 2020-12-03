package scene2;

import scene1.*;

public class fightCommand implements Command {
	Place[] places;
	Player p;
	FightStrategy fst;
	TCP_Client tcp;
	public fightCommand(Place[] places, Player p, TCP_Client tcp) {
		this.places = places;
		this.p = p;
		this.tcp = tcp;
	}

	@Override
	public void execute(String s) {
		if (p.getPosition() == 12) {
			if (s.contains("gun")) {
				fst = new GunFight(p,tcp);
			} else if (s.contains("hand")) {
				fst = new HandFight(tcp);
			} else if (s.contains("pan")) {
				fst = new PanFight(tcp);
			} else if (s.contains("knife")) {
				fst = new KnifeFight(tcp);
			} else {
				System.out.println("I cannot fight using this!");
				return;
			}
			fst.fight();
		} else {
			System.out.println("I should not fight anyone here");
			return;
		}
	}
}
