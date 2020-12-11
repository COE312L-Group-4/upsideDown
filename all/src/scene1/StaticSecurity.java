package scene1;
import scene2.*;


public class StaticSecurity extends Security{

	public StaticSecurity(Player p, Time t) {
		super(p, t);


	}

	public StaticSecurity(String name, int age, int position, String job, Player p, Time t) {
		super(name, age, position, job, p, t);
	}

	@Override
	public void posChange() {
		System.out.println("A Security guard is waiting in the victim's room monitoring the door");
		this.setPosition(7);
		//System.out.println("Security position " + this.getPosition()+ " player position " + player.getPosition());
		if (player.getPosition() == this.getPosition()) {
			System.out.println("You have been caught by the security!\nGame over.");
			t.setTimeup(true);
		}
	}

	@Override
	public void update(int p) {
		if (this.getPosition() == p) {
			System.out.println("You have been caught by the security!\nGame over.");
			player.removeObsever(this);		
			t.setTimeup(true);
		}
		
	}

	@Override
	public void talk(Player p) {
		System.out.println("I'm a static security");

	}

	@Override
	public void updateTime(int count) {
		if(count == 60) {
			this.posChange();	
			t.removeObsever(this);
		}
		
	}


}