package models;

public class Customer {

	
	private int custId;
	private String custName;
	private String contactPerson;
	private String address;
	private String phone;
	private String email;
	private String status;
	
	
//	constructors
	public Customer() 
	{
			
		this.custId = 0;
		this.custName = "";
		this.contactPerson = "";
		this.address = "";
		this.phone = "(876)";
		this.email = "";
		this.status = "active";
	}
	
	
	public Customer(int custId, String custName, String contactPerson, String address, 
		String phone, String email, String status) 
	{
		
		this.custId = custId;
		this.custName = custName;
		this.contactPerson = contactPerson;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}

	
//	Getters and Setters
	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", contactPerson=" + contactPerson
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", status=" + status + "]";
	}
	

	
	
	
	
	
	
}
