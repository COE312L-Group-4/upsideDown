package scene1;
import scene2.*;

public class Gun extends Object {

	
	public Gun() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gun(String color) {
		super("gun", color, "You can find the gun in the car", true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void use(Player p,String s) {
		System.out.println("You can only use the Gun to fight using the fight command");
	}


	

}
