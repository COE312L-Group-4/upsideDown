package scene2;

import scene1.*;
import scene1.Object;

public class Sushi extends Object {

	int count;
	Sound sound;

	public Sushi(String color, Sound s) {
		super("sushi", color, "a sushi plate on the table", false);
		sound = s;
		count = 0;
	}

	@Override
	public void use(Player p) {
		if (count < 4) {
			System.out.println("Hmmm.. never tried sushi before");
			sound.playSound();
			if (p.getHealth() == 100) {
				System.out.println("Your health is already full!");
			} else {
				p.setHealth(p.getHealth() + 5);
				System.out.println("Your health is now = " + p.getHealth() + " /100!");
			}
			count++;
		} else {
			System.out.println("enough sushi for now");
		}

	}

	@Override
	public void errorMessage() {
	}

}
