package scene1;

import scene2.*;

public class Room303 extends Place {

	@Override
	public void look() {

	}

	public Room303() {
		super();
	}

	@Override
	public void walk(String s) {
		System.out.println("This is Room 3");
		p.setPosition(0);
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
