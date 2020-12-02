package scene2;

import scene1.Person;

//This should be an observer for the time or the location of the player so he can talk
public class ITFriend extends Person {

	private static ITFriend instance;


	private ITFriend(String name, int age, int position) {
		super(name, age, position, "IT Consultant");
	}
	
	
	public static synchronized ITFriend getInstance(String name, int age, int position){
		if(instance == null){
			instance = new ITFriend(name,age,position);
		}
		return instance;
	}


	@Override
	public void talk() {
		System.out.println("i'm a nerd");
		
	}
}
