import java.util.Arrays;

public class PlayerRoom extends Place{
	String [] avaliablePos = {"hallway"};
	
	public PlayerRoom() {
		super("You entered your room!.\n",5,true);
		items=new Object [100];
		items[0] = new CoffeeMaker();
		items[1] = new RoomCard();
		items[2] = new RoomWindow();
		items[3] = new Cupboard();
	}
	@Override
	public void look() {
		//array with the exsiting objects and without the removed objects
		System.out.println("you have kza kza in your room");
	}
	
	public void startDescription() {
		System.out.println("STORY LINE AND IMPORTANT COMMANDS .. DON'T FORGET THIS YA 7YWAN");
	}
	
}
