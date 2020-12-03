package scene3;
import scene1.*;
import scene2.*;

public class LivingRoom extends Place {
	String[] avaliablePos = { " " }; //add the available positions

	public LivingRoom(Player p, Sound s) {
		super("You entered the living room", 13, true);
		characters.add(ITFriend.getInstance(p,s));

	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int walk(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
