
public class MovingSecurity extends Security {

	int c;
	int[] Securitypath = { 7, 2, 5, 2, 8, 2, 9, 2, 4, 2, 6, 2, 10, 2, 3, 2 };
	String [] locationName = {"Hallway", "House Keeping Room", "Laundry Room","your room","Security Room","Victim's Room","Room 315","Room 316","Room 387"};

	public MovingSecurity(Player p) {
		super(p);
		p.registerObserver(this);
		c = 0;
	}

	public MovingSecurity(String name, int age, int position, String job, Player p) {
		super(name, age, position, job, p);
		p.registerObserver(this);
	}

	@Override
	public void posChange() {
		this.setPosition(Securitypath[c]);
		System.out.println("A security guared is moving around and is currently trying to find you on " + locationName[Securitypath[c]-2]);
		c = c % 16;
		c++;
	}

	@Override
	public void update(int p) {
		if (this.getPosition() == p) {
			System.out.println("You have been caught by the security!\nGame over!.");
		}
	}

}
