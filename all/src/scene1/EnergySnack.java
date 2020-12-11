package scene1;

import scene2.*;

public class EnergySnack extends Object {
	int count;
	Sound sound;
	public EnergySnack(String color,Sound s) {
		super("energy snack", color, "Your favorite energy snack is on the chair next to you", true);
		this.sound = s;
		count = 0;
	}

	@Override
	public void use(Player p, String s) {
		if (s.contains("use") || s.contains("eat")) {

			if (count <= 3) {
				count++;
				System.out.println("Best part of my day so far");
				sound.playSound();
				p.setHealth(p.getHealth() + 10);
				System.out.println("You feel energized..");
			} else {
				System.out.println("I have eaten enough snacks for now");
			}
		} else {
			System.out.println("You can't use this object with that command");
		}

	}
}
