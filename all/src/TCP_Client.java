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

public class TCP_Client implements Runnable, SubjectSensor {

	// ip address of the machine
	String host = "192.168.0.122"; // N 192.168.1.148 // A 192.168.0.122

	// need the port
	int port = 8080;

	JSONParser parser = new JSONParser();
	private ArrayList observers;
	

	TCP_Client(String host, int port) {

		// set the ip address and the port of the
		// the server we will connect to.

		this.host = host;
		this.port = port;
		observers = new ArrayList();

		// make this a thread
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {

		try {

			// create an instance of the Socket
			// try to create a socket connection to
			// host using port

			// block -- the program will wait here \
			// to form a connection.
			// if somthing goes wrong, the progrma will
			// create an exception

			Socket socket = new Socket(host, port);

			// returns a socket object

			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			// -------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";

			int count = 0;
			while (true) {
				// Extracting the x,y,z coordinates
				double accx = 0;
				double accy = 0;
				double accz = 0;

				double gyrx = 0;
				double gyry = 0;
				double gyrz = 0;
				int gyrxabs = 0;
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
					
					gyrxabs += Math.abs((int)(Double.parseDouble((String) jsonObject.get("gyroRotationX")))); 
					
				}
				accx /= count;
				accy /= count;
				accz /= count;

				gyrx /= count;
				gyry /= count;
				gyrz /= count;
				
				gyrxabs /= count;

				// ----------------------------------------------------------------------------
				if ((accy >= 0.2 || accy <= -0.2) && (accz <= -1.1 || accz >= 0.2)) {
					notifyObservers(accx, accy, accz, gyrx, gyry, gyrz);
					Thread.sleep(1000);

				}
				if ((gyrxabs >= 2)) {
					notifyObservers(accx, accy, accz, (double)gyrxabs, gyry, gyrz);
					Thread.sleep(1000);
				}

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
		if (i>=0) observers.remove(i);
	}

	@Override
	public void notifyObservers(double accx, double accy, double accz, double gyrx, double gyry, double gyrz) {
		for (int i = 0; i < observers.size(); i++) {
			Object observer = (Object) observers.get(i);
			observer.update(accx, accy, accz, gyrx, gyry, gyrz);
		}
	}

}