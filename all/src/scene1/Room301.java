package scene1;

import scene2.*;

public class Room301 extends Place {

	public Room301() {
		super();

	}

	@Override
	public void look() {
	}

	@Override
	public void walk(String s) {
		System.out.println("This is Room 1");
		p.setPosition(0);
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
