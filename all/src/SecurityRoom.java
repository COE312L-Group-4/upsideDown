
public class SecurityRoom extends Place{
	String [] avaliablePos = {"hallway"};
	public SecurityRoom() {
		super("You entered the security room!.\n",6,false);
		items.add(new SecurityCamera());
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub

	}
	@Override
	public int walk(String s) {
		
		if(s.contains("hallway")) {
			return 1;
		}
		else if(s.contains("302") || s.contains("301") || s.contains("303")) {
			System.out.println("This place is locked, please try another place");
		}else {
			System.out.println("There is nosuch place, please try another place");
		}
		return pos;
		
	}
}
