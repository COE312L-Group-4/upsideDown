
public class HouseKeepingRoom extends Place {
	String[] avaliablePos = { "hallway" };
	

	public HouseKeepingRoom() {
		super("You entered the house keeping room!.", 3, false);
		items.add(new Microwave("Blue"));
	}

	@Override
	public void look() {
		System.out.println("You are in the house keeping room, you can see the follwoing objects:");  
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can only walk to the hallway");
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
