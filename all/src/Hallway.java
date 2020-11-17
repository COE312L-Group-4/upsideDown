
public class Hallway extends Place{
	String [] avaliablePos = {"elevator","housekeeping","laundry","314","security","394"};
	public Hallway() {
		super("you are standing in the hallway!.\n",2);
		items=new Object [100];
		items[0]=new FireExtinguisher();
		
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}

}
