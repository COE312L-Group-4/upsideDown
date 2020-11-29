import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerRoom extends Place {
	String[] avaliablePos = { "hallway" };

	public PlayerRoom() {
		super("You entered your room!.\n", 5, true);
		items.add(new CoffeeMaker("Black", "There is a Coffee maker on the table next to the window")); // health and sound																				
		items.add(new Phone("White"));
	}

	@Override
	public void look() {
		System.out.println("You are in your hotel room, you can find the follwoing objects:");    //Room descrption
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).description);
		}
	}

	public void startDescription() {
		System.out.println("STORY LINE AND IMPORTANT COMMANDS .. DON'T FORGET THIS YA 7YWAN");
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
