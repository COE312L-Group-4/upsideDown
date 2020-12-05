package scene1;
import scene2.*;

public class EnergySnack extends Object {
	int count;

	public EnergySnack(String color) {
		super("energy snack", color, "Your favorite energy snack is on the chair next to you", true);
		count = 0;
	}

	@Override
	public void use(Player p) {
		if (count <= 3) {
			count++;
			System.out.println("Best part of my day so far");
			p.setHealth(p.getHealth() + 10);
			System.out.println("You feel energized..");
		} else {
			System.out.println("I have eaten enough snacks for now");
		}
	}

	@Override
	public void errorMessage() {
	}

}
