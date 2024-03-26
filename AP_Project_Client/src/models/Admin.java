package models;

public class Admin extends Staff {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String password;

	public Admin() {
		super();
		this.password = "";
	}

	public Admin(String firstName, String lastName, Date dob, String address, String phone, String email, String position, String status, String password) {
		super(firstName, lastName, dob, address, phone, email, position, status);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	@Override
//	public String toString() {
//		return super.toString() + ", password=" + password + "]";
//	}
}