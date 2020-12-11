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

	@Override
	public void walk(String s) {
		System.out.println("This is Room 2");
		p.setPosition(0);

	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
