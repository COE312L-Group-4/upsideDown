package scene1;
public class Time implements Runnable {
	private int count;
	final int PoliceTime = 900; // in secs
	final int SecurityTime = 180; // in secs
	boolean Timeup = false;
	boolean enteredVicRoom = false;
	Player p;

	public Time(Player p) {
		count = 0;
		this.p = p;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			while (!enteredVicRoom) {
				if (p.getPosition() == 7) {
					enteredVicRoom = true;
				}
				Thread.sleep(30000);
			}
			System.out.println(
					"You have been spotted by the security while entering the victim's room!\nThe security will reach the room in only 3 minutes..They have also called the police which will arrive in 15 minutes");
			System.out.println("Instructions: Try to hide in different locations in the hotel to not get caught and collect the evidence");
			while (!Timeup) {

				Thread.sleep(1000);
				count++;
				if (count % 60 == 0 && count != 0 && count <= 180) { // 2 mins for the security
					if (count == 180) {
						System.out.println("The securities have arrived to the victim's room");
					} else {
						System.out.println("You have " + ((SecurityTime - count) / 60)
								+ " minutes remaining for the Security arrival");	
					}
					if (count % 300 == 0) {			
						System.out.println("You have " + ((PoliceTime - count) / 60)
								+ " minutes remaining for the police arrival ");
					}
					if(count % 7 == 0) {
						p.setHealth((p.getHealth())-1);
					}

				} else if (count >= 900) { // 15 mins for the police men
					System.out.println("15 minutes has passed..Gameover!");
					this.setTimeup(true);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public synchronized boolean isTimeup() {
		return Timeup;
	}

	public synchronized void setTimeup(boolean timeup) {
		Timeup = timeup;
	}

	public synchronized int getCount() {
		return count;
	}

}