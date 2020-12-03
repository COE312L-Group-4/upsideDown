package scene2;

import scene1.*;
import scene1.Object;

public class KnifeFight extends FightStrategy {
	boolean knife;
	private TCP_Client tcp;
	
	public KnifeFight(TCP_Client tcp) {
		this.tcp = tcp;
		this.tcp.registerObserver(this);
		this.knife = false;
	}

	@Override
	public void fight() {
		knife = true;
	}

	@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint,String act) {
		if(knife) {
			
		}
	}

}
