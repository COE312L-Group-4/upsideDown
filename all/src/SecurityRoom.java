
public class SecurityRoom extends Place{
	String [] avaliablePos = {"hallway"};
	public SecurityRoom() {
		super("You entered the security room!.\n",6);
		items=new Object [100];
		items[0] = new SecurityCamera();
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub

	}
}
