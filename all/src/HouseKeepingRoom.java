
public class HouseKeepingRoom extends Place{
	String [] avaliablePos = {"hallway"};
	
	public HouseKeepingRoom() {
		super("You entered the house keeping room!.\n",3, false);
		items=new Object [100];
		
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
	}

}
