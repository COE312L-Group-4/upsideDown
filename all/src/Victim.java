
// Use the Singleton pattern 
public class Victim extends Person {
	private static Victim instance;

	private Victim(String name, int age, int position) {
		super(name, age, position,"Victim");
		
	}
	
	
	//can we use singleton with 2 constructors (Only used the non-default)
	public static synchronized Victim getInstance(String name, int age, int position){
		if(instance == null){
			instance = new Victim(name,age,position);
		}
		return instance;
	}
}
