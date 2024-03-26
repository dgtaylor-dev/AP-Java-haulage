package client;


import models.Customer;
import models.RouteRate;
import models.Staff;

public class ClientDriver {

	public static void main(String[] args) {
		
		Client client = new Client();
		
		
		
		Staff staff = new Staff("test", "test", null, "test address", "8768905778", 
				"test", "test", "active");
		
		Customer customer = new Customer("Test", "Test", "test", "test", "test", 
				"test", "876", "test", "");
		
		RouteRate routeRate = new RouteRate("test2 route name", "test2 source", "test2 dest", 10700.00);
		
		client.sendRequestToServer();
		
//		client.addCustomer(customer);
		
//		client.sendRouteRate(routeRate);
		
		
//		client.registerStaff(staff);
		
//		client.getStaffById(10024);
		
		client.sendRouteSearchKey("test route name");
		
		client.recieveServerReponse();
		
		client.closeConnection();
		
	}

}
