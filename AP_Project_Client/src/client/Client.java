
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


import models.Staff;

public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Socket socket;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	private String request = "";
	
	
	Scanner scanner = new Scanner(System.in);
	

	
	public Client() {
//		create a  new socket instance
		try {
			socket = new Socket("127.0.0.1", 9999);
			
//			configure the input and output streams
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			inputStream = new ObjectInputStream(socket.getInputStream());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public void sendRequestToServer() {
		try {
			
			System.out.println("Write request: ");
			request = scanner.nextLine();
			
			outputStream.writeObject(request);
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			scanner.close();
		}
	}
	
	
	
	
	
	public void registerStaff(Staff staff) {
		
		try {
			outputStream.writeObject(staff);
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	
	public void getStaffById(int adminId) {
		
		try {
			outputStream.writeObject(adminId);
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
//	receive responses from server
	public void recieveServerReponse() {
		
		try 
		{
//			response from server which determines whether or not admin was registered successfully;
			if(request.equalsIgnoreCase("add admin")){
				
				Boolean flag = (Boolean) inputStream.readObject();
				if(flag == true) {
					System.out.println("Admin registered successfully"); 
				}
				else {
					System.out.println("There was a problem adding user");
				}
				
			}
//			retrieve admin from database for the purpose of logging in
			else if(request.equalsIgnoreCase("get admin")){
				
				int staffIdNum = (int) inputStream.readObject();
				System.out.println("Found ID: " + staffIdNum);
				
			}
			else {
				return;
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
