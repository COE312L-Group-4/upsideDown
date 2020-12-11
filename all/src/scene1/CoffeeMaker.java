package scene1;
import scene2.*;

public class CoffeeMaker extends Object {
	int count;
	Sound sound;

	public CoffeeMaker(String color, Sound s) {
		super("coffee maker", color, "a coffee maker beside the bed", false);
		sound = s;
		count = 0;
	}

	@Override
	public void use(Player p, String s) {
		if(s.contains("use") || s.contains("open")) {
			if (count < 4) {
				System.out.println("Hmmm.. What a delicious coffee");
				sound.playSound();
				p.setHealth(p.getHealth() + 5);
				count++;
			} else {
				System.out.println("I have got more than enough coffee in my system");
			}
		}else {
			System.out.println("You can't use this object with that command");
		}

	}


}
