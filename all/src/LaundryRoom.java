
public class LaundryRoom extends Place{
	String [] avaliablePos = {"hallway"};
	public LaundryRoom() {
		super("You entered the laundry room!.\n",4,true);
		items.add(new WashingMachine());
		items.add(new Chair());
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int walk(String s) {
		if ((s.contains(avaliablePos[0])) && (s.contains("walk"))) {
			return (1);
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;
	}

}