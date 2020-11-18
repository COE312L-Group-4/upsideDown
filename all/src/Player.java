
// Use the Singleton pattern 
public class Player extends Person {
	
	private static Player instance;
	int Score;
	int Health; //this could be a state or something
	Object [] bag;
	
	private Player(String name, int age, int position) {
		super(name, age, position, "Player");
		bag = new Object[5];
	}
	
	
	
	
	//can we use singleton with 2 constructors (Only used the non-default)
	public static synchronized Player getInstance(String name, int age, int position){
		if(instance == null){
			instance = new Player(name,age,position);
		}
		return instance;
	}
	
	
}
