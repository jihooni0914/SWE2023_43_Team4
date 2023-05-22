package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	
	public ClientThread(Socket s) {
		this.socket = s;
	}
	
	@Override
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			writer = new PrintWriter(this.socket.getOutputStream());
			
			String recv_msg = null;
			while ((recv_msg = reader.readLine()) != null) {
				String[] event = recv_msg.split("");
				
				eventManager(event);
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void eventManager(String[] event) {
		
	}
}
