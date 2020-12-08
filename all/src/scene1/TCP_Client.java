package scene1;

import scene2.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import scene2.FightStrategy;
import scene2.SubjectFight;

public class TCP_Client implements Runnable, SubjectSensor, SubjectFight {

	// ip address of the machine
	String host = "192.168.0.122"; // N 192.168.1.148 // A 192.168.0.122

	// need the port
	int port = 8080;

	Player p;
	JSONParser parser = new JSONParser();
	private ArrayList observers;
	private ArrayList observersfight;

	TCP_Client(String host, int port, Player p) {

		// set the ip address and the port of the
		// the server we will connect to.

		this.host = host;
		this.port = port;
		observers = new ArrayList();
		observersfight = new ArrayList();
		this.p = p;
		// make this a thread
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	public void run() {

		try {

			Socket socket = new Socket(host, port);

			// returns a socket object

			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			// -------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";

			int count;
			while (!p.isLoss() && !p.isFinish()) {
				// Extracting the x,y,z coordinates
				double accx = 0;
				double accy = 0;
				double accz = 0;
				int accxabs = 0;
				int accyabs = 0;
				int acczabs = 0;

				double gyrx = 0;
				double gyry = 0;
				double gyrz = 0;
				int gyrxabs = 0;
				int gyryabs = 0;
				int gyrzabs = 0;

				int countLandLeft = 0; // 3
				int countLandRight = 0; // 4
				int countOther = 0; // otherwise
				int orintation = 0;

				count = 0;

				// Thread.sleep(5000);
				/*
				 * for (int j = 0; j < 20; j++) { br.readLine(); }
				 */
				while ((line = br.readLine()) != null && count < 15) {// read line by line
					// parse String to JSON
					JSONObject jsonObject = (JSONObject) parser.parse(line);
					count++;
					// print the object
					//System.out.println(jsonObject);

					// Extracting the x,y,z coordinates
					accx += Double.parseDouble((String) jsonObject.get("accelerometerAccelerationX"));
					accy += Double.parseDouble((String) jsonObject.get("accelerometerAccelerationY"));
					accz += Double.parseDouble((String) jsonObject.get("accelerometerAccelerationZ"));

					gyrx += Double.parseDouble((String) jsonObject.get("gyroRotationX"));
					gyry += Double.parseDouble((String) jsonObject.get("gyroRotationY"));
					gyrz += Double.parseDouble((String) jsonObject.get("gyroRotationZ"));

					// ------The readings absoulte values
					accxabs += Math
							.abs((int) (Double.parseDouble((String) jsonObject.get("accelerometerAccelerationX"))));
					accyabs += Math
							.abs((int) (Double.parseDouble((String) jsonObject.get("accelerometerAccelerationY"))));
					acczabs += Math
							.abs((int) (Double.parseDouble((String) jsonObject.get("accelerometerAccelerationZ"))));

					gyrxabs += Math.abs((int) (Double.parseDouble((String) jsonObject.get("gyroRotationX"))));
					gyryabs += Math.abs((int) Double.parseDouble((String) jsonObject.get("gyroRotationY")));
					gyrzabs += Math.abs((int) Double.parseDouble((String) jsonObject.get("gyroRotationZ")));
					// Count the number for the orientation

					if (((String) jsonObject.get("deviceOrientation")).equals("3")) {
						countLandLeft++;
					} else if (((String) jsonObject.get("deviceOrientation")).equals("4")) {
						countLandRight++;
					}

				}

				accx /= count;
				accy /= count;
				accz /= count;

				gyrx /= count;
				gyry /= count;
				gyrz /= count;

				// ------------average of absolute value----------
				accxabs /= count;
				accyabs /= count;
				acczabs /= count;

				gyrxabs /= count;
				gyryabs /= count;
				gyrzabs /= count;

				// ----------------------------------------------------------------------------
//				System.out.println("Readings in the TCP_Client thread....");
				//System.out
					//	.println("----------------------------------------------------------------------------\naccy: "
						//		+ accy + "\taccz: " + accz + "\tgryx: " + gyrx + "\taccyabs = " + accyabs
							//	+ "\n ----------------------------------------------------------------------------");
				if ((accy >= 0.2 || accy <= -0.4) && (accz <= -1 || accz >= 0.2)) {
					// notifyObservers(accx, accy, accz, gyrx, gyry, gyrz);
					// System.out.println("fire b4");
					Message m = new Message(this, "doorlock", "broke");
					publishMessageObject(m);
					// System.out.println("fire aft");
					// Thread.sleep(1000);

				}
				if ((gyrxabs >= 2)) {
					// notifyObservers(accx, accy, accz, (double) gyrxabs, gyry, gyrz);
					// System.out.println("fire b4");
					Message m = new Message(this, "roomwindow", "jumped");
					publishMessageObject(m);
					// System.out.println("fire aft");

					// Thread.sleep(1000);

				}
				if (countLandLeft >= 7) {
					orintation = 3;
				} else if (countLandRight >= 7) {
					orintation = 4;
				} else {
					orintation = 0;
				}

				if (orintation == 4 || orintation == 3) {
					// notifyObservers(accx, accy, accz, (double) gyrxabs, gyry, gyrz, orintation);
					// System.out.println("gun b4");
					Message m = new Message(this, "gunfight", "gunwon");
					publishMessageFight(m);
					// System.out.println("gun b4");
					// Thread.sleep(1000);

				}

				if ((accy >= 0.12) || (accy <= -0.3)) {
					// notifyObservers(accx, accy, accz, gyrx, gyry, gyrz, orintation);
					// System.out.println("hand b4");
					Message m = new Message(this, "handfight", "handwon");
					publishMessageFight(m);
					// System.out.println("hand b4");
					// Thread.sleep(1000);
				}

				if ((accy >= 0.4 || accy <= -0.1) && (accz <= -0.5) && (gyrx >= 1 || gyrx <= -1)) {
					// notifyObservers(accx, accy, accz, gyrx, gyry, gyrz, orintation);
					// System.out.println("pan b4");
					Message m = new Message(this, "panfight", "panwon");
					publishMessageFight(m);
					// System.out.println("pan b4");
					// Thread.sleep(1000);

				}
				if ((accx >= 0.2 || accx <= -0.8) && (accy >= 0.1 || accy <= -0.1) && (gyrz >= 0.5 || gyrz <= -0.5)) {
					// notifyObservers(accx, accy, accz, gyrx, gyry, gyrz, orintation);
					// System.out.println("knife b4");
					Message m = new Message(this, "knifefight", "knifewon");
					publishMessageFight(m);
					// System.out.println("knife b4");

					// Thread.sleep(1000);
				}

				//Thread.sleep(1000);

			}
		} catch (UnknownHostException ex) {

			System.out.println("Server not found: " + ex.getMessage());

		} catch (IOException ex) {

			System.out.println("I/O error: " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void registerObserver(Object o) {
		observers.add(o);
	}

	@Override
	public void removeObsever(Object o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	/*
	 * @Override public void notifyObservers(double accx, double accy, double accz,
	 * double gyrx, double gyry, double gyrz) { for (int i = 0; i <
	 * observers.size(); i++) { Object observer = (Object) observers.get(i);
	 * observer.update(accx, accy, accz, gyrx, gyry, gyrz); } }
	 */

	/*
	 * @Override public void notifyObservers(Message m) { for (int i = 0; i <
	 * observers.size(); i++) { Object observer = (Object) observers.get(i);
	 * observer.update(m); } }
	 */
	public void publishMessageObject(Message m) {
		for (int i = 0; i < observers.size(); i++) {
			Object observer = (Object) observers.get(i);
			observer.update(m);
		}
	}

	@Override
	public void registerObserver(FightStrategy fs) {
		observersfight.add(fs);
	}

	@Override
	public void removeObsever(FightStrategy fs) {
		int i = observersfight.indexOf(fs);
		if (i >= 0)
			observersfight.remove(i);

	}

	/*
	 * @Override public void notifyObservers(double accx, double accy, double accz,
	 * double gyrx, double gyry, double gyrz, int orientation) { for (int i = 0; i <
	 * observersfight.size(); i++) { FightStrategy observersf = (FightStrategy)
	 * observersfight.get(i); observersf.update(accx, accy, accz, gyrx, gyry, gyrz,
	 * orientation); } }
	 */

	public void publishMessageFight(Message m) {
		for (int i = 0; i < observersfight.size(); i++) {
			FightStrategy observer = (FightStrategy) observersfight.get(i);
			observer.update(m);
		}
	}

}