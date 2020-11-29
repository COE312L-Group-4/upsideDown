/*import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TCP_Client implements Runnable {

	// ip address of the machine
	String host = "192.168.0.122"; // N 192.168.1.148 // A 192.168.0.122

	// need the port
	int port = 8080;

	JSONParser parser = new JSONParser();

	TCP_Client(String host, int port) {

		// set the ip address and the port of the
		// the server we will connect to.

		this.host = host;
		this.port = port;

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

			// grab the input stream so I can read the sensors

			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			// -------------------------------- new reader -------------------------------
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			String[] commands = { "Simon says: Place the phone on its right side",
					"Simon says: Place the phone on its left side", "Simon says: Rotate the phone vertically",
					"Simon says: Rotate the phone horizontally", "Place the phone on its right side",
					"Place the phone on its left side", "Rotate the phone vertically",
					"Rotate the phone horizontally" };
			Random rand = new Random();
			int rand_int1, count;
			
			for (int i = 0; i < 3; i++) {
				// System.out.println(line);
				rand_int1 = rand.nextInt(8);
				System.out.println(commands[rand_int1]);
				// Extracting the x,y,z coordinates
				double accx = 0;
				double accy = 0;
				double accz = 0;

				double gyrx = 0;
				double gyry = 0;
				double gyrz = 0;
				count = 0;
				Thread.sleep(5000);
				for(int j = 0; j <20; j++) {
					br.readLine();
				}
				while ((line = br.readLine()) != null && count<15) {// read line by line
					// parse String to JSON
					JSONObject jsonObject = (JSONObject) parser.parse(line);
					count++;
					// print the object
					System.out.println(jsonObject);

					// select a specific value using its key
					//JSONObject accelerometerObj = (JSONObject) jsonObject.get("accelerometer");
					//JSONObject gyroObj = (JSONObject) jsonObject.get("gyroscope");

					// Extracting acc and gyro object
					//JSONArray accVal = (JSONArray) accelerometerObj.get("value");
					//JSONArray gysVal = (JSONArray) gyroObj.get("value");

//					String xrot = (String) jsonObject.get("gyroRotationX");
//					double x=Double.parseDouble(xrot);
					
					// Extracting the x,y,z coordinates
					accx +=  Double.parseDouble((String)jsonObject.get("accelerometerAccelerationX"));
					accy +=  Double.parseDouble((String)jsonObject.get("accelerometerAccelerationY"));
					accz +=  Double.parseDouble((String)jsonObject.get("accelerometerAccelerationZ"));

					gyrx += Double.parseDouble((String) jsonObject.get("gyroRotationX"));
					gyry += Double.parseDouble((String) jsonObject.get("gyroRotationY"));
					gyrz += Double.parseDouble((String) jsonObject.get("gyroRotationZ"));

					
					// print the selected value
					//System.out.println("Logging time is: "+ accx);
				}
				 accx/=count;
				 accy/=count;
				 accz/=count;
				 
				 gyrx/=count;
				 gyry/=count;
				 gyrz/=count;
				 
				// Placed on the right
				if ((accx > -11 && accx < -9) && (accy < 0.5 && accy > -0.7) && (accz < 0 && accz > -0.6) && ((int)gyrx==0 && (int)gyry==0 && (int)gyrz == 0)) {
					System.out.println("The phone is on the right");
					if (rand_int1 == 0) {
						System.out.println("Nice one!");
					} else {
						System.out.println("Try harder!");
					}
					// Placed on the left
				} else if ((accx > 9 && accx < 11) && (accy < 1.7 && accy > 0) && (accz < 1 && accz > 0) && ((int)gyrx==0 && (int)gyry==0 && (int)gyrz == 0)) {
					System.out.println("The phone is on the left");
					if (rand_int1 == 1) {
						System.out.println("Nice one!");
					} else {
						System.out.println("Try harder!");
					}
					// rotate vertical
				} else if ((accx > -5 && accx < 5) && (accy < 10 && accy > -12) && (accz < 13 && accz > -14) && (gyrx > 0 && gyrx < 4) && (gyry > -2 && gyry < 1.5) && (gyrz > -1 && gyrz < 1)) {
					System.out.println("The phone is rotating vertical");
					if (rand_int1 == 2) {
						System.out.println("Nice one!");
					} else {
						System.out.println("Try harder!");
						// rotate horizontal
					}
				} else if ((accx > -2 && accx < 4) && (accy < 1 && accy > -5) && (accz < 11 && accz > 8) && (gyrx > -1 && gyrx < 2) && (gyry > -1 && gyry < 1) && (gyrz > 0 && gyrz < 5)) {
					System.out.println("The phone is rotating horizontal");
					if (rand_int1 == 3) {
						System.out.println("Nice one!");
					} else {
						System.out.println("Try harder!");

					}
				} else {
					System.out.println("System is standing still");

					if (rand_int1 == 4 || rand_int1 == 5 || rand_int1 == 6 || rand_int1 == 7) {
						System.out.println("Nice one!");
					} else {
						System.out.println("Try harder!");
					}
				}
			
			}
			// ----------------------------------------------------------------------------

		} catch (UnknownHostException ex) {

			System.out.println("Server not found: " + ex.getMessage());

		} catch (IOException ex) {

			System.out.println("I/O error: " + ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}*/