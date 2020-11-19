
public class Elevator extends Place{
	String [] avaliablePos = {"hallway"};
	public Elevator() {
		super("You have entered the Elevator you can go back to the hallway or exit the hotel.\n",1,false);
		items = new Object [10];
		items[0] = new Button("Up");
		items[1] = new Button("Down");
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}

}
