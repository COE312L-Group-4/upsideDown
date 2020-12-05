package scene1;
import scene2.*;

public class car extends Place {

	String[] avaliablePos = { "resturant", "friend home" };
	
	public car() {
		super("You have entered your car!\n", 0, true);
		items.add(new Gun("Black"));
		items.add(new EnergySnack("Brown"));
		items.add(new Water("transparent"));

	}

	@Override
	public void look() {
		System.out.println("You entered your car, you can see the follwoing objects:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
	}

	@Override
	public int walk(String s) {
		
		if (((s.contains("sushi")) || (s.contains("downtown")) ||(s.contains("restaurant"))) && (s.contains("drive")))
		{
			return 11;
		}else {
			System.out.println("There is no such place, please try another place");
		}

		return pos;
	}


}
