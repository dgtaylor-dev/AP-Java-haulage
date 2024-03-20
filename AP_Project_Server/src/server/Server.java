package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import models.Staff;

public class Server {
	
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectOutputStream outputStream = null;
	private ObjectInputStream inputStream = null;
	private Connection dbConnection;
	private Statement sqlStatement;

	
	Scanner scanner = new Scanner(System.in);
	
	
	public Server() {
		
		createSocketInstance();
		connectToDatabase();
		respondToClientRequest();
	}
	
//	create server socket instance
	private void createSocketInstance() 
	{
		try {
			serverSocket = new ServerSocket(9999);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	configure input and output streams  for server socket
	private void configureStreams() 
	{
		try 
		{
//			reads data from socket
			inputStream = new ObjectInputStream(socket.getInputStream());
			
//			writes data to socket
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

//	create connection to the database
	private Connection connectToDatabase() {
		
		String url = "jdbc:mysql://localhost:3306";
		
		if(dbConnection == null) {
			
			try {
				 dbConnection = DriverManager.getConnection(url, "root", "");
				 System.out.println("database connected successfully");
			
			} catch (SQLException e) {
				System.out.println("Failed to connect to database");
				e.printStackTrace();
			}
		}
		
		return dbConnection;
		
	}
	
//	close connection
	@SuppressWarnings("unused")
	private void closeConnection() {
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
	
	
//	utility methods

	
//	register admin
	private void registerAdminUser(Staff adminStaff) {		
		
	try {
			
	        String sqlQuery = "INSERT INTO test.staff(first_name, last_name, address, phone, email, position, status_) " +
	        "VALUES ('" + adminStaff.getFirstName() + "', '" + adminStaff.getLastName() + "', '" + adminStaff.getAddress() 
	        + "', '" + adminStaff.getPhoneNum() + "', '" + adminStaff.getEmail() + "', '" + adminStaff.getPosition() 
	        + "', '" + adminStaff.getStatus() + "')";

	        sqlStatement = dbConnection.createStatement();
	        int status = sqlStatement.executeUpdate(sqlQuery);

	        if (status == 1) {
	            outputStream.writeObject(true);
//	            outputStream.flush();
	            
	        } else {
	            outputStream.writeObject(false);
//	            outputStream.flush();
	        }
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
//	send requests to server
	private void respondToClientRequest() {
		
//		initialize socket variable with the server socket accept method
//		allows server to wait continuously on client requests via a endless loop
		while(true) {
			
			try {
				socket = serverSocket.accept();
				
//				configure input and output streams for this socket
				configureStreams();
			
//				print client request
				Staff reqFromClient = (Staff) inputStream.readObject();
				System.out.println(reqFromClient);
				
				registerAdminUser(reqFromClient);
				
//				if(reqFromClient.equalsIgnoreCase("add user")) {
//					Staff staffToAdd = (Staff) inputStream.readObject();
//					
//				}
				
//				respond to client
//				String resToClient = scanner.nextLine();
//				outputStream.writeObject(resToClient);
//				outputStream.flush();
				
			
			} catch (IOException e) {
				e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		

	}
	
	

	
	
	

}
