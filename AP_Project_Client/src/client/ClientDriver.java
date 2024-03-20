package client;

import models.Date;
import models.Staff;

public class ClientDriver {

	public static void main(String[] args) {
		
		Client client = new Client();
		
		Staff staff = new Staff("Mary", "Jane", null, "10 light of life street", "129302376", "maryjane@gmail.com", "Admin", "active");
		
//		client.sendRequestToServer();
		
		client.registerStaff(staff);
	
		
		client.recieveServerReponse();
		
		
		client.closeConnection();
	

	}

}
