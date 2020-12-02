
public class Elevator extends Place {
	String[] avaliablePos = { "hallway" };

	public Elevator() {
		super("You have entered the Elevator you can go back to the hallway or exit to your car.", 2, false);
		items.add(new Button("grey"));
	}

	@Override
	public void look() {
		System.out.print("You are in the elevator, you can use the exit button to exit the hotel and move to the next scene\nor you can go back to the hallway"); 
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
