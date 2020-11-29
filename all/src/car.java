
public class car extends Place {

	String[] avaliablePos = { "hotel", "", "friend home" };

	public car() {
		super("You have entered your car!\n", 0, false);
	}

	@Override
	public void look() {
		// TODO Auto-generated method stub

	}

	@Override
	public int walk(String s) {
		System.out.println("This is the car");
		return 0;
	}


}
