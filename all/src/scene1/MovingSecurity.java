package scene1;
import scene2.*;

public class MovingSecurity extends Security {

	int c;
	int[] Securitypath = { 1, 7, 1, 5, 1, 8, 1, 9, 1, 4, 1, 6, 1, 10, 1, 3, 1 };
	String[] locationName = { "Hallway", " ", "House Keeping Room", "Laundry Room", "your room", "Security Room",
			"Victim's Room", "Room 315", "Room 316", "Room 387" };
	Place place;

	public MovingSecurity(Player p, Time t, Place laundry) {
		super(p, t);
		player.registerObserver(this);
		t.registerObserver(this);
		place = laundry;
		c = 0;
	}

	public MovingSecurity(String name, int age, int position, String job, Player p, Time t) {
		super(name, age, position, job, p, t);
		player.registerObserver(this);
		t.registerObserver(this);

	}

	@Override
	public void posChange() {
		if (locationName[Securitypath[c] - 1].contains("Laundry Room")) {
			if (!place.isOpen()) {
				c += 2;
				c = c % 16;
			}
		}
		this.setPosition(Securitypath[c]);
		System.out.println("A security guard is moving around and is currently trying to find you in "
				+ locationName[Securitypath[c] - 1]);
		c++;
		c = c % 16;

		if (player.getPosition() == this.getPosition()) {
			System.out.println("You have been caught by the security!\nGame over.");
			player.removeObsever(this);
			t.setTimeup(true);
		}

	}

	@Override
	public void update(int p) {
		if (this.getPosition() == p) {
			System.out.println("You have been caught by the security!\nGame over!.");
			player.removeObsever(this);
			t.setTimeup(true);
		}
	}

	@Override
	public void talk(Player p) {
		System.out.println("I'm a moving security");

	}

	@Override
	public void updateTime(int count) {
		if (count == 180) {
			this.posChange();
		} else if (count >= 180 && count % 30 == 0) {
			this.posChange();
		}
	}

}
