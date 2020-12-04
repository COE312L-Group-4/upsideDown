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
		this.fst = new HandFight(tcp,p);
	}

	@Override
	public void execute(String s) {
		if (p.getPosition() == 12) {
			fst.performFight(s,fst,p,tcp);
		} else {
			System.out.println("I should not fight anyone here");
			return;
		}
	}
}
//panel for each situation
