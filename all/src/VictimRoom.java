import java.util.ArrayList;

public class VictimRoom extends Place{
	String [] avaliablePos = {"hallway"};
	public VictimRoom() {
		super("You entered room 394!.\n",7,true);
		items.add(new VictimPhone());
		items.add(new Safe());
		items.add(new VictimID());
		items.add(new RoomWindow());
		
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int walk(String s) {
		if(s.contains("hallway")) {
			return 1;
		}
		else if(s.contains("302") || s.contains("301") || s.contains("303")) {
			System.out.println("This place is locked, please try another place");
		}else {
			System.out.println("There is nosuch place, please try another place");
		}
		return pos;
	}
}
