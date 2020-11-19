public class Time implements Runnable {
	private int count;
	final int PoliceTime = 900; // in secs
	final int SecurityTime = 120; // in secs

	public Time() {
		count = 0;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		System.out.println(
				"You have been spotted by the security while entering the victim's room!\nThe police will arrive in 15 minutes while the security will reach the room in only 2 minutes!");
		while (true) {
			try {
				Thread.sleep(1000);
				count++;
				if (count % 60 == 0 && count != 0 && count <= 120) {
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
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public synchronized int getCount() {
		return count;
	}
}