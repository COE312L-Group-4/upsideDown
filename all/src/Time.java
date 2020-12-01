public class Time implements Runnable {
	private int count;
	final int PoliceTime = 900; // in secs
	final int SecurityTime = 120; // in secs
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
				Thread.sleep(1000);
			}
			System.out.println(
					"You have been spotted by the security while entering the victim's room!\nThe police will arrive in 15 minutes while the security will reach the room in only 2 minutes!");

			while (!Timeup) {

				Thread.sleep(1000);
				count++;
				if (count % 60 == 0 && count != 0 && count <= 120) { // 2 mins for the security
					if (count == 120) {
						System.out.println("The securities have arrived to the victim's room");
					} else {
						System.out.println("You have " + ((SecurityTime - count) / 60)
								+ " minutes remaining for the Security arrival");
					}
					if (count % 300 == 0) {
						System.out.println("You have " + ((PoliceTime - count) / 60)
								+ " minutes remaining for the police arrival ");
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