
public abstract class Security extends Person implements Observer{
	private Player p;
	
	public Security(Player p) {
		super();
		this.p=p;
	}

	public Security(String name, int age, int position, String job, Player p) {
		super(name, age, position, job);
		this.p=p;
	}
	public abstract void posChange();

	public abstract void update(int p);
}