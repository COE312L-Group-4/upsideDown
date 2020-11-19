import java.util.*;


public class driver {

	public static void main(String[] args) {
		
		//Places Initialization
		Place [] places = new Place[8];
		places[0] = new car ();
		places[1] = new Elevator();
		places[2] = new Hallway();
		places[3] = new HouseKeepingRoom();
		places[4] = new LaundryRoom();
		places[5] = new PlayerRoom();
		places[6] = new VictimRoom();
		places[7] = new SecurityRoom();
		
		
		System.out.println("**Welcome to Upside Down!**\nEnter your name");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		
		
		System.out.println("ay 7agh kdh " + name);
		System.out.println("Type start to start");
		
		// Enter the Start Phrase
		String MP = s.nextLine().toLowerCase();
	    while (!MP.contains("start"))
	    {
	    	System.out.println("The magic words you entered are not magical enough\nEnter the magic word CORRECTLY:");
	    	MP = s.nextLine();
	    }
		Player p = Player.getInstance(name,40, 5);
	    Time t = new Time();
	    SecurityControl sc = new SecurityControl(t,p);
	    
	    /*Security [] sec;
	    sec[0] = new Static*/
	    
	    
	}

}
