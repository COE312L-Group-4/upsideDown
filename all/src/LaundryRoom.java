
public class LaundryRoom extends Place{
	String [] avaliablePos = {"hallway"};
	public LaundryRoom() {
		super("You entered the laundry room!.\n",4,true);
		items=new Object [10];
		items[0]=new WashingMachine();
		items[1] = new Chair();
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}
}