import java.util.ArrayList;

public class VictimRoom extends Place {
	String[] avaliablePos = { "hallway" };

	public VictimRoom() {
		super("You entered room 394..\nThere is a dead body on the ground!!", 7, true);
		items.add(new VictimPhone("Black"));
		items.add(new Safe("Grey"));
		items.add(new VictimID("White"));
		items.add(new RoomWindow("Red"));

	}

	@Override
	public void look() {
		System.out.println(
				"You are in hotel room 394, There is a dead body, security have seen me entring the room, most probably they will accuse me for murdering him!\nI need to stay low and find who really did it..");
		System.out.println("you can see the follwoing objects:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can only walk to the hallway");

	}

	@Override
	public int walk(String s) {
		if (s.contains("hallway")) {
			return 1;
		} else if (s.contains("302") || s.contains("301") || s.contains("303")) {
			System.out.println("This place is locked, please try another place");
		} else {
			System.out.println("There is nosuch place, please try another place");
		}
		return pos;
	}
}
