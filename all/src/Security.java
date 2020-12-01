
public abstract class Security extends Person implements Observer{
	Player p;
	Time t;
	public Security(Player p, Time t) {
		super();
		this.t = t;
		this.p=p;
	}

	public Security(String name, int age, int position, String job, Player p, Time t) {
		super(name, age, position, job);
		this.p=p;
		this.t = t;
	}
	public abstract void posChange();

	public abstract void update(int p);
}