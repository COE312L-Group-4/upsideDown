package scene1;

import scene2.*;

public class Water extends Object {

	int count;
	Sound s;
	public Water(String color,Sound s) {
		super("water", color, "Your usual water bottle", true);
		this.s =s;
		count = 0;
	}

	@Override
	public void use(Player p, String input) {
		if (input.toLowerCase().contains("drink"))
			if (count <= 3) {
				count++;

				System.out.println("I feel hydrated..\n");
				s.playSound();
				p.setHealth(p.getHealth() + 5);

			} else {
				System.out.println("Enough water for now");
			}
		else {
			System.out.println("You cannot use this object with this command");
		}
	}
}
