
public class CoffeeMaker extends Object {
	int count;

	public CoffeeMaker(String color,String descp) {
		super("coffee maker", color, descp, false);
		count = 0;
	}

	@Override
	public void use(Player p) {
		if (count < 4) {
			System.out.println("Hmmm.. What a delicious coffee");
			if (p.getHealth() == 100) {
				System.out.println("Your health is already full!");
			} else {
				p.setHealth(p.getHealth() + 5);
				System.out.println("Your health is now = " + p.getHealth() + " /100!");
			}
			count++;
		} else {
			System.out.println("I have got more than enough coffee in my system");
		}

	}

	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub
	}

}
