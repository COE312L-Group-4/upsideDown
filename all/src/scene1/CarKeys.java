package scene1;
import scene2.*;

public class CarKeys extends Object{

	
	public CarKeys() {
		super();
	}

	public CarKeys(String color) {
		super("car keys", color,"These are car keys",true);
	}

	@Override
	public void use(Player p,String s) {
		System.out.println("You have the car keys in your bag");
		
	}

}
