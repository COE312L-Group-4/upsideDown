package scene2;

import scene1.Place;

public class Kitchen extends Place {
	String[] avaliablePos = { "dining hall", "exit" };

	public Kitchen() {
		super("You have entered the kitchen!\n", 12, true);
		characters.add(new HaroSato());
	}

	@Override
	public void look() {
		// TODO Auto-generated method stub

	}

	@Override
	public int walk(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
