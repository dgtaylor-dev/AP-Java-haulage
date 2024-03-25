package client;


import models.Staff;

public class ClientDriver {

	public static void main(String[] args) {
		
		Client client = new Client();
		
		Staff staff = new Staff("Mary", "Jane", null, "10 light of life street", "129302376", "maryjane@gmail.com", "Admin", "active");
		
	
		client.sendRequestToServer();
		
//		client.registerStaff(staff);
		
		client.getStaffById(10020);
		
		client.recieveServerReponse();
		
		client.closeConnection();
		
	}

}
