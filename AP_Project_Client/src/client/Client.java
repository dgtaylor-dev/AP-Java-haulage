
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import models.Customer;
import models.RouteRate;
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
	
//	add customer method
	public void addCustomer(Customer customer) {
		
		try {
			outputStream.writeObject(customer);
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
//	send route/rate to server
	public void sendRouteRate(RouteRate routeRate) {
		try {
			outputStream.writeObject(routeRate);
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	send route/rate to server
	public void sendRouteSearchKey(String searchKey) {
		try {
			outputStream.writeObject(searchKey);
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
			if (request.equalsIgnoreCase("get admin")){
				
				int staffIdNum = (int) inputStream.readObject();
				System.out.println("Found ID: " + staffIdNum);
				
			}
			
//			receive server response stating if the request to add a customer was met
			if(request.equalsIgnoreCase("add customer")){
				
				Boolean customerAdded = (Boolean) inputStream.readObject();
				if(customerAdded == true) {
					System.out.println("customer added successfully"); 
				}
				else {
					System.out.println("Could not add customer");
				}
				
			}
			
//			receive server response stating if the request to add a route/rate was met
			if(request.equalsIgnoreCase("add route")){
				
				Boolean routeToAdd = (Boolean) inputStream.readObject();
				if(routeToAdd == true) {
					System.out.println("Route/Rates added successfully"); 
				}
				else {
					System.out.println("Could not add Route/Rate");
				}
				
			}
			
			
//			receive searched item response from server
			if(request.equalsIgnoreCase("get route")){
				
				RouteRate route = (RouteRate) inputStream.readObject();
				System.out.println("Route Found:  " + route);
				
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
