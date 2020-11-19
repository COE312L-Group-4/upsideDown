
public class VictimRoom extends Place{
	String [] avaliablePos = {"hallway"};
	public VictimRoom() {
		super("You entered room 394!.\n",7,true);
		items=new Object [100];
		items[0] = new VictimPhone();
		items[1] = new Safe();
		items[2] = new VictimID();
		
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}

}
