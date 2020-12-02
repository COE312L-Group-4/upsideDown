package scene1;

public class Water extends Object {

	int count;

	public Water(String color) {
		super("water", color, "Your usual water bottle", true);
		count = 0;
	}

	@Override
	public void use(Player p) {
		if (count <= 3) {
			count++;
			p.setHealth(p.getHealth() + 5);
			System.out.println("I feel hydrated..\nyour health is now " + p.getHealth() + "/100");
		} else {
			System.out.println("Enough water for now");
		}
	}

	@Override
	public void errorMessage() {
	}

}
