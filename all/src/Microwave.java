
public class Microwave extends Object {

	int count;

	public Microwave(String color) {
		super("microwave", color, "a microwave on the table with a box of pizza beside", false);
		count = 0;
	}

	@Override
	public void use(Player p) {
		if (count < 4) {
			System.out.println("Hmmm... my favorite pizza!");
			if (p.getHealth() == 100) {
				System.out.println("Your health is already full!");
			} else {
				p.setHealth(p.getHealth() + 5);
				System.out.println("Your health is now = " + p.getHealth() + " /100!");
			}
			count++;
		} else {
			System.out.println("I have got more than enough pizza in my system");
		}

	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub

	}

}
