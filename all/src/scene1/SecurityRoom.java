package scene1;

public class SecurityRoom extends Place {
	String[] avaliablePos = { "hallway" };

	public SecurityRoom() {
		super("You entered the security room!", 6, false);
		items.add(new SecurityCamera("black"));
	}

	@Override
	public void look() {
		System.out.println("You are in security room, you can find the following objects:");    //Room descrption
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can only walk to the hallway");
	}

	@Override
	public int walk(String s) {

		if (s.contains("hallway")) {
			return 1;
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;

	}
}
