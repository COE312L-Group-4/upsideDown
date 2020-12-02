package scene2;

import scene1.Place;
import scene1.Object;
import scene1.*;


public class DinningHall extends Place {
	String[] avaliablePos = { "Kitchen" };

	public DinningHall() {
		super("You have entered the dinning hall of Happu Sushi resturant.", 11, true);
		characters.add(new Cashier());
	}

	@Override
	public void look() {
		System.out.println("You are in the Dining hall, you can see the follwoing:");  
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
		System.out.println("You can only walk to the Kitchen");
	}

	@Override
	public int walk(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
