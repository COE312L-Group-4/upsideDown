package scene2;

import scene1.*;
import java.util.*;

public abstract class FightStrategy implements ObserverStrategy {
	Scanner cin;
	private TCP_Client tcp;

	public FightStrategy(TCP_Client tcp) {
		this.tcp = tcp;
		this.tcp.registerObserver(this);
	}

	final void performFight(String s, FightStrategy f, Player p, TCP_Client tcp) { // FINAL IS A MUST
		f = checkInput(s, p, tcp);
		if (f.ItemNeeded()) {
			f.checkItem();
		}
		f.fight();
	}

	protected FightStrategy checkInput(String s, Player p, TCP_Client tcp) {
		if (s.toLowerCase().contains("gun")) {
			return new GunFight(p, tcp);
		} else if (s.toLowerCase().contains("hand")) {
			return new HandFight(tcp, p);
		} else if (s.toLowerCase().contains("pan")) {
			return new PanFight(tcp, p);
		} else if (s.toLowerCase().contains("knife")) {
			return new KnifeFight(tcp, p);
		} else {
			System.out.println("You can only fight by hand by default...");
			return this;
		}
	}

	public boolean ItemNeeded() {
		return false;
	}

	public abstract void checkItem();

	public abstract void fight();

	protected void Confess(Player player) {
		tcp.removeObsever(this);
		System.out.println("HaruSato: Enough Enough!!.. I will tell you everything...");
		System.out.println(
				"HaruSato: He was blackmailing me to false witness in one of his casses.. I had no other choice.. he was going to take my kids away..");
		System.out.println(player.name + ": You should have truseted the law...");
		System.out.println(player.name + ": You are going to jail for a very long time my friend");
		player.setScore(player.getScore() + 20);
		player.setFinish(true);
	}

	public abstract void update(Message m);
}
