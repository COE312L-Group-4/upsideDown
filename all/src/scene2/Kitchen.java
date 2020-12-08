package scene2;
import scene1.*;


import scene1.Place;

public class Kitchen extends Place {
	String[] avaliablePos = { "dining hall"};

	public Kitchen() {
		super("You have entered the kitchen!", 12, true);
		characters.add(new HaruSato());
	}

	@Override
	public void look() {
		if(!items.isEmpty()) {
			System.out.println("You are in the Kitchen, you can see the follwoing:");
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).description);
			}
		}
		System.out.println("You can see a knife on the table and a Pan on the cooker");
		System.out.println("You can see the following characters that you can talk to: ");
		for (int i = 0; i < characters.size(); i++) {
			System.out.println(characters.get(i).name);
		}
		System.out.println("You can walk to the dining hall");
	}

	@Override
	public int walk(String s) {
		for (int i = 0; i < avaliablePos.length; i++) {
			if ((s.contains(avaliablePos[i])) && (s.contains("walk"))) {
				return 11;
			}
		}
		System.out.println("There is no such place, please try another place");
		return pos;
	}

}
