
public class car extends Place {

	String[] avaliablePos = { "hotel", "", "friend home" };
	
	public car() {
		super("You have entered your car!\n", 0, true);
		items.add(new Gun("Black"));
	}

	@Override
	public void look() {
		System.out.println("You entered your car, you can see the follwoing objects:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can only walk to the hallway");
	}

	@Override
	public int walk(String s) {
		
		System.out.println("This is the car");
		return 0;
	}


}
