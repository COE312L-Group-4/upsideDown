package scene1;
import scene2.*;


public class Room302 extends Place {
	
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}
	
	public Room302() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room302(String description, int pos, boolean state) {
		super(description, 9, false);
	}

	@Override
	public int walk(String s) {
		System.out.println("This is Room 2");
		return 0;
		
	}

}
