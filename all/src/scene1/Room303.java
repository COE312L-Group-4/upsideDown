package scene1;
import scene2.*;


public class Room303 extends Place {

	@Override
	public void look() {
		
	}

	public Room303() {
		super("You entered Room 3",10,false);

	}

	@Override
	public int walk(String s) {
		System.out.println("This is Room 3");
		return 0;
	}



}
