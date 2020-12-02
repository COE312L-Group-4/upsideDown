
public class SecurityControl implements Runnable{
	
	Security [] s;
	Time time;
	Player p;
	public SecurityControl(Time time, Player p,Place lr) {
		s=new Security[2];
		this.p=p;
		s[0] = new StaticSecurity(p, time);
		s[1] = new MovingSecurity(p,time,lr);
		this.time = time;
		Thread t=new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		while(!time.isTimeup()) {  
			try {
				if(time.getCount() >= 180) //Time in the range that we want ? 
				{
					s[1].posChange();
					if(time.getCount() == 180) {s[0].posChange();}
					Thread.sleep(30000);
				}
			}catch(Exception e) {
				System.out.println(e);			
			}
		}
	}
	
}
