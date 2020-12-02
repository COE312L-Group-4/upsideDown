package scene1;

public class Hallway extends Place {
	String[] avaliablePos = { "elevator", "housekeeping room", "laundry room", "room 314", "security room", "room 394" }; // 2,3,4,5,6,7
	
	public Hallway(TCP_Client subject,Place sr) {
		super("you are standing in the hallway!", 1, true);
		items.add(new FireExtinguisher("Red",subject, sr)); // sensor

	}

	@Override
	public void look() {
		System.out.println("You are in the hallway, you can find the following objects:"); // Room descrption
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can see the following places:");
		for (int i = 0; i < avaliablePos.length; i++) {
			System.out.println(avaliablePos[i]);
		}
		System.out.println("room 301\nroom 302\nroom 303\n");
		System.out.println("You notice that the door for room 394 is slightly open\nYour detective instinct is sensing that something is wrong");

	}

	@Override
	public int walk(String s) {
		for (int i = 0; i < avaliablePos.length; i++) {
			if ((s.contains(avaliablePos[i])) && (s.contains("walk"))) {
				return (i + 2);
			}
		}
		if (s.contains("302") || s.contains("301") || s.contains("303")) {
			System.out.println("This place is locked, please try another place");
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;
	}

}
