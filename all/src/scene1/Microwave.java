package scene1;
import scene2.*;

public class Microwave extends Object {

	int count;
	Sound s;
	public Microwave(String color, Sound s) {
		super("microwave", color, "a microwave on the table with a box of pizza beside", false);
		count = 0;
		this.s = s;
	}

	@Override
	public void use(Player p,String input) {
		if(input.contains("use") || input.contains("open") || input.contains("press")) {
		if (count < 4) {
			System.out.println("Hmmm... my favorite pizza!");
			s.playSound();
			p.setHealth(p.getHealth() + 5);	
			count++;
		} else {
			System.out.println("I have got more than enough pizza in my system");
		}
		
		}else {
			System.out.println("You can't use this object with that command");
		}

	}


}
