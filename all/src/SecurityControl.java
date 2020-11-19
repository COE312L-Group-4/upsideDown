
public class SecurityControl implements Runnable{
	
	Security [] s;
	Time time;
	Player p;
	public SecurityControl(Time time, Player p) {
		s=new Security[10];
		this.p=p;
		s[0] = new StaticSecurity(p);
		s[1] = new MovingSecurity(p);
		this.time = time;
		Thread t=new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		while(true) {  
			try {
				if(time.getCount() >= 120) //Time in the range that we want ? 
				{
					s[1].posChange();
					if(time.getCount() == 120) {s[0].posChange();}
					Thread.sleep(30000);
				}
			}catch(Exception e) {
				System.out.println(e);			}
		}
	}
	
}
