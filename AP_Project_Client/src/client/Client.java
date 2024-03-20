
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import models.Staff;

public class Client {
	
	
	private Socket socket = null;
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	

	
	public Client() {
		createSockeInstance();
		configureStreams();
	}

//	create socket instance
	private void createSockeInstance() {
		
		try {
			socket = new Socket("127.0.0.1", 9999);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	configure input and output streams for the socket created
	private void configureStreams() {
		
		try {
//			for sending data to the server
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			
//			for receiving data from server
			inputStream = new ObjectInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	close connection
	public  void closeConnection() {
		try {
			if(socket != null) {
				socket.close();
			}
			outputStream.close();
			inputStream.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	Send requests to server
	public void sendRequestToServer() {
		
		Scanner scanner = new Scanner(System.in);
	
		try {
			
			System.out.println("Write request: ");
			String msgToSend = scanner.nextLine();
				
			outputStream.writeObject(msgToSend);
			outputStream.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			scanner.close();
	}
	
	public void registerStaff(Staff staff) {
		
		try {
			outputStream.writeObject(staff);
			outputStream.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	receive responses from server
	public void recieveServerReponse() {
		
		try 
		{
//			String serverResponse = (String) inputStream.readObject();
//			System.out.println(serverResponse);
			
			Boolean flag = (Boolean) inputStream.readObject();
			if(flag == true) {
				System.out.println("User added successfully");
			}
			else {
				System.out.println("There was a problem adding user");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
