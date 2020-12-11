package scene1;
import scene2.*;


public abstract class Security extends Person implements ObserverTime, Observer {
	Player player;
	Time t;

	public Security(Player p, Time t) {
		super();
		this.t = t;
		this.player = p;
		this.player.registerObserver(this);
		this.t.registerObserver(this);
	}

	public Security(String name, int age, int position, String job, Player p, Time t) {
		super(name, age, position, job);
		this.player = p;
		this.t = t;
		this.player.registerObserver(this);
		this.t.registerObserver(this);
	}

	public abstract void posChange();

	public abstract void update(int p);

	public abstract void updateTime(int count);

}