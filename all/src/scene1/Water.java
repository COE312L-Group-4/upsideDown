package scene1;
import scene2.*;


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
		
			System.out.println("I feel hydrated..\n");

				p.setHealth(p.getHealth() + 5);
			
		} else {
			System.out.println("Enough water for now");
		}
	}

	@Override
	public void errorMessage() {
	}

}
