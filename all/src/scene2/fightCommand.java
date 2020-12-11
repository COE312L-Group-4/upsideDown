package scene2;

import scene1.*;

public class fightCommand implements Command {
	
	Place pla;
	Player p;
	FightStrategy fst;
	TCP_Client tcp;
	public fightCommand(Place pla, Player p, TCP_Client tcp) {
		this.pla = pla;
		this.p = p;
		this.tcp = tcp;
		this.fst = new HandFight(tcp,p);
	}

	@Override
	public void execute(String s) {
			fst.performFight(s,fst,p,tcp);
	}
}
//panel for each situation
//location client
