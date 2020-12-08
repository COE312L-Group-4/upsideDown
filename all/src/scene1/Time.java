package scene1;

import scene2.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import scene2.FightStrategy;

public class Time implements Runnable, SubjectTime {
	private int count;
	final int PoliceTime = 900; // in secs
	final int SecurityTime = 180; // in secs
	boolean Timeup = false;
	boolean enteredVicRoom = false;
	Player p;
	private ArrayList<Security> observers;

	public Time(Player p) {
		count = 0;
		this.p = p;
		observers = new ArrayList<Security>();
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	@Override
	public void run() {
		try {
			while (!enteredVicRoom) {
				if (p.getPosition() == 7) {
					enteredVicRoom = true;
					Thread.sleep(30000);
				}
			}
			if (enteredVicRoom) {

				System.out.println(
						"You have been spotted by the security while entering the victim's room!\nThe security will reach the room in only 3 minutes..They have also called the police which will arrive in 15 minutes");
				System.out.println(
						"Instructions: Try to hide in different locations in the hotel to not get caught and collect the evidence (You can use the map to figure out the securite route) ");
				while (!Timeup && p.getPosition() != 0 && !p.isLoss()) {

					Thread.sleep(1000);
					notifyObservers(count);
					count++;
					if (count % 60 == 0 && count != 0 && count <= 180) { // 3 mins for the security
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
						if (count % 7 == 0) {
							p.setHealth((p.getHealth()) - 1);
						}

					} else if (count >= 900) { // 15 mins for the police men
						System.out.println("15 minutes has passed..Gameover!");
						this.setTimeup(true);
					}

				}
				//System.out.println("time finished");

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
		if (Timeup) {
			p.setLoss(true);
		}
	}

	public synchronized int getCount() {
		return count;
	}

	@Override
	public void registerObserver(Security o) {
		observers.add(o);
	}

	@Override
	public void removeObsever(Security o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers(int c) {
		for (int i = 0; i < observers.size(); i++) {
			Security observerstemp = (Security) observers.get(i);
			observerstemp.updateTime(c);
		}
	}

}