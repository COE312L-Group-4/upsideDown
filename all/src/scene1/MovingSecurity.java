package scene1;

import scene2.*;
import java.util.*;

public class MovingSecurity extends Security {

	int c;
	int sct;
	int[] Securitypath = { 1, 7, 1, 5, 1, 8, 1, 9, 1, 4, 1, 6, 1, 10, 1, 3, 1 };
	String[] locationName = { "Hallway", " ", "House Keeping Room", "Laundry Room", "your room", "Security Room",
			"Victim's Room", "Room 315", "Room 316", "Room 387" };
	String[] securitytalk = { "I wil find you my friend", "You can't run away from me",
			"You think you can escape easily... you are wrong!", "police is gonna be here in any second now" };
	Place place;
	Random r;

	public MovingSecurity(Player p, Time t, Place laundry) {
		super(p, t);
		place = laundry;
		c = 0;
		sct = 0;
		r = new Random();

	}

	public MovingSecurity(String name, int age, int position, String job, Player p, Time t) {
		super(name, age, position, job, p, t);
		sct = 0;
		r = new Random();
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
		System.out.println();
		sct = r.nextInt(4);
		System.out.println("Security: " + securitytalk[sct]);
		c++;
		c = c % 16;

		if (player.getPosition() == this.getPosition()) {
			System.out.println("You have been caught by the security!\nGame over.");
			System.out.println();
			player.removeObsever(this);
			t.setTimeup(true);
		}

	}

	@Override
	public void update(int p) {
		if (this.getPosition() == p) {
			System.out.println("You have been caught by the security!\nGame over!.");
			System.out.println();
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
		if (count == 60) {
			this.posChange();
		} else if (count >= 60 && count % 15 == 0) {
			this.posChange();
		}
	}

}
