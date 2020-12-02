
public class FireExtinguisher extends Object {

	
	public FireExtinguisher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FireExtinguisher(String color) {
		super("fire extinguisher", color, "A fire extinguisher at the end of the hallway",false);
	}


	@Override
	public void errorMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void use(Player p) {
		System.out.println("");
	}


}
