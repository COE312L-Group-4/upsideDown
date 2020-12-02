package scene1;
public class StaticSecurity extends Security {

	public StaticSecurity(Player p, Time t) {
		super(p, t);
		p.registerObserver(this);
	}

	public StaticSecurity(String name, int age, int position, String job, Player p, Time t) {
		super(name, age, position, job, p, t);
		p.registerObserver(this);
	}

	@Override
	public void posChange() {
		System.out.println("A Security guard is waiting in the victim's room monitoring the door");
		this.setPosition(6);
		if (p.getPosition() == this.getPosition()) {
			System.out.println("You have been caught by the security!\nGame over.");
			t.setTimeup(true);
		}
	}

	@Override
	public void update(int p) {
		if (this.getPosition() == p) {
			System.out.println("You have been caught by the security!\nGame over.");
			t.setTimeup(true);
		}
	}

	@Override
	public void talk() {
		System.out.println("I'm a static security");
		
	}

}