public class StaticSecurity extends Security{

	public StaticSecurity(Player p) {
		super(p);
		p.registerObserver(this);
	}

	public StaticSecurity(String name, int age, int position, String job, Player p) {
		super(name, age, position, job, p);
		p.registerObserver(this);
	}


	@Override
	public void posChange() {
		System.out.println("A Security guard is waiting in the victim's room monitoring the door");
		this.setPosition(6);	
	}

	@Override
	public void update(int p) {
		if(this.getPosition() == p) {
			System.out.println("You have been caught by the security!\nGame over.");
		}
	}

}