package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import models.Staff;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket socket = null;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Connection dbConnection;
	private Statement sqlStatement;
	
	String action = "";

	
	Scanner scanner = new Scanner(System.in);
	
	
	public Server() {
		
//		create server socket instance
		try {
			serverSocket = new ServerSocket(9999);
//			connect to MySQL database
			connectToDatabase();
			
//			start listening continuously for requests from client
			while(true) {
				socket = serverSocket.accept();
				
				RequestHandler reqThread = new RequestHandler(socket);
				Thread thread = new Thread((Runnable) reqThread);
//			
				thread.start();
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	create connection to the database
	private Connection connectToDatabase() {
		
		String url = "jdbc:mysql://localhost:3306/java_hlg_db";
		
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
	
	
	public class RequestHandler implements Runnable {
		
		Socket socket;
		ObjectOutputStream outputStream;
		ObjectInputStream inputStream;
		
		RequestHandler(Socket socket){
			this.socket = socket;
			try {
				this.outputStream = new ObjectOutputStream(socket.getOutputStream());
				this.inputStream = new ObjectInputStream(socket.getInputStream());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
			String req = "";
			try {
				req = (String) inputStream.readObject();
				System.out.println(req);
				
				if(req.equalsIgnoreCase("add admin")) {
					Staff staff = (Staff) inputStream.readObject();
					registerStaff(staff);
				}
				
				if(req.equalsIgnoreCase("get admin")) {
					int staffId = (int) inputStream.readObject();
					getStaffById(staffId);
					
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
//		register admin
		@SuppressWarnings("unused")
		private void registerStaff (Staff staff) {		
			
		try {
				
		        String sql = "INSERT INTO java_hlg_db.staff(first_name, last_name, address, phone, email, position, status_) " +
		        "VALUES ('" + staff.getFirstName() + "', '" + staff.getLastName() + "', '" + staff.getAddress() 
		        + "', '" + staff.getPhoneNum() + "', '" + staff.getEmail() + "', '" +staff.getPosition() 
		        + "', '" + staff.getStatus() + "')";

		        sqlStatement = dbConnection.createStatement();
		        int status = sqlStatement.executeUpdate(sql);

		        if (status == 1) {
		            outputStream.writeObject(true);
//		            outputStream.flush();
		            
		        } else {
		            outputStream.writeObject(false);
//		            outputStream.flush();
		        }
			
			}catch (SQLException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		private  void getStaffById(int staffId) {
			
			String sql = "SELECT * FROM java_hlg_db.staff WHERE staff_id = " + staffId ;
			
			try {
				sqlStatement = dbConnection.createStatement();
				ResultSet result = sqlStatement.executeQuery(sql);
				
				if(result.next()) {
					int staffIdFound = result.getInt("staff_id");
					
//					send the result set to the client side
					outputStream.writeObject(staffIdFound);
					outputStream.flush();
				}
				else {
					System.out.println("Could not find staff with ID: " + staffId);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	


	
	




}
