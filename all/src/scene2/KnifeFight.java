package scene2;


import scene1.*;
import scene1.Object;

public class KnifeFight extends FightStrategy {
	boolean knife;
	//private TCP_Client tcp;
	int updateCount;
	Player p;
	public KnifeFight(TCP_Client tcp, Player p) {
		super(tcp);
		//this.tcp = tcp;
		//this.tcp.registerObserver(this);
		this.knife = false;
		this.updateCount = 0;
		this.p = p;
	}

	@Override
	public void fight() {
		knife = true;
		System.out.println("Place the phone screen up while moving the phone diagonally to use the knife");

	}

	/*@Override
	public void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint) {
		if (knife) {
			if ((accx >= 0.2 || accx <= -0.8) && (accy >= 0.7) && (gyrz >= 1 || gyrz <= -1)) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("I am hurt by knife");
				} else {
					knife = false;
					p.setHealth(p.getHealth()-30);
					Confess(p);
				}
			}
		}
	}*/
	
	@Override
	public void update(Message m) {
		if (knife) {
			if ((m.condition.toLowerCase().contains("knifewon"))) {
				updateCount++;
				if (updateCount <= 2) {
					System.out.println("You are swinging the knife at Haru Sato's. He is close to confessing!");
				} else {
					knife = false;
					p.setHealth(p.getHealth()-30);
					Confess(p);
				}
			}
		}
	}

	

	public void checkItem() {

	}

}
