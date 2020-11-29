
public class Hallway extends Place{
	String [] avaliablePos = {"elevator","housekeeping","laundry","314","security","394"};  //2,3,4,5,6,7
	public Hallway() {
		super("you are standing in the hallway!.\n",1, true);
		items.add(new FireExtinguisher());
		
	}
	@Override
	public void look() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int walk(String s) {
		for(int i=0; i< avaliablePos.length;i++) {
			if((s.contains(avaliablePos[i])) && (s.contains("walk"))) {
				return (i+2);
			}
		}
		if(s.contains("302") || s.contains("301") || s.contains("303")) {
			System.out.println("This place is locked, please try another place");
		}else {
			System.out.println("There is nosuch place, please try another place");
		}
		return pos;
	}

}
