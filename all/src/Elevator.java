
public class Elevator extends Place {
	String[] avaliablePos = { "exit", "hallway" };

	public Elevator() {
		super("You have entered the Elevator you can go back to the hallway or exit the hotel.\n", 2, false);
		items.add(new Button("Up"));
		items.add(new Button("Down"));
	}

	@Override
	public void look() {
		// TODO Auto-generated method stub

	}

	@Override
	public int walk(String s) {
		for (int i = 0; i < avaliablePos.length; i++) {
			if ((s.contains(avaliablePos[i])) && (s.contains("walk"))) {
				return i;
			}
		}
		System.out.println("There is no such place, please try another place");

		return pos;
	}


}
