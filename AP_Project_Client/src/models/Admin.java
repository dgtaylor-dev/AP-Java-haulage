package models;


public class Admin extends Staff{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String password = "";
	
	public Admin() {
		
	}

	public Admin(String firstName, String lastName, String password, Date dob, String address, String phone, String email,
			String position, String status) {
		
		super(firstName, lastName, dob, address, phone, email, position, status);
		this.password = password;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
	
}
