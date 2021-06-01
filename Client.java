// Client class that
// sends data and receives also

import java.io.*;
import java.net.*;

class Client {

	public static void main(String args[])
		throws Exception
	{

		// Create client socket
		Socket s = new Socket("localhost", 888);

		// to send data to the server
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		// to read data coming from the server
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// to read data from the keyboard
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		String msgin, msgout;

		// repeat as long as exit
		// is not typed at client
		while (!(msgin = kb.readLine()).equals("exit")) {

			// send to the server
			dos.writeBytes("Client: " + msgin + "\n");

			// receive from the server
			msgout = br.readLine();

			System.out.println(msgout);
		}

		// close connection.
		dos.close();
		br.close();
		kb.close();
		s.close();
	}
}