package scene1;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerRoom extends Place {
	String[] avaliablePos = { "hallway" };

	public PlayerRoom(Sound s) {
		super("You entered your room!.", 5, true);
		items.add(new CoffeeMaker("Black",s)); // health and sound																				
	}

	@Override
	public void look() {
		if(!items.isEmpty()) {
			System.out.println("You are in your hotel room, you can find the follwoing objects:");    //Room descrption
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).description);
			}
		}
		System.out.println("You can only walk to the hallway");
	}


	@Override
	public int walk(String s) {
		if ((s.contains("hallway")) && (s.contains("walk"))) {
			return 1;
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;
	}

}
