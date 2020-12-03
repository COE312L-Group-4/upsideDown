package scene1;

public class Elevator extends Place {
	String[] avaliablePos = { "hallway" };

	public Elevator() {
		super("You have entered the Elevator you can go back to the hallway or exit to your car.", 2, true);
		items.add(new Button("grey"));
	}

	@Override
	public void look() {
		System.out.print("You are in the elevator, you can use the exit button to exit the hotel and move to the next scene\nor you can go back to the hallway"); 
	}

	@Override
	public int walk(String s) {
		if ((s.contains(avaliablePos[0])) && (s.contains("walk"))) {
			return (1);
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;
	}

}
