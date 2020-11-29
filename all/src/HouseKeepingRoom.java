
public class HouseKeepingRoom extends Place {
	String[] avaliablePos = { "hallway" };

	public HouseKeepingRoom() {
		super("You entered the house keeping room!.\n", 3, false);

	}

	@Override
	public void look() {
		// TODO Auto-generated method stub
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
