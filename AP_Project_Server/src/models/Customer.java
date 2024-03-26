package models;

import java.io.Serializable;

public class Customer implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int custId;
	private String company;
	private String contactPerson;
	private String address1;
	private String address2;
	private String po;
	private String parish;
	private String phone;
	private String email;
	private String status;
	
	
//	constructors
	public Customer() 
	{
			
		this.custId = 0;
		this.company = "";
		this.contactPerson = "";
		this.address1 = "";
		this.address2 = "";
		this.po = "";
		this.parish = "";
;		this.phone = "876";
		this.email = "";
		this.status = "";
	}
	
	
	public Customer(String compName, String contactPerson, String address1, String address2, 
		String po, String parish, String phone, String email, String status) 
	{
		
//		this.custId = custId;
		this.company = compName;
		this.contactPerson = contactPerson;
		this.address1 = address1;
		this.address1 = address2;
		this.po = po;
		this.parish = parish;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getPo() {
		return po;
	}


	public void setPo(String po) {
		this.po = po;
	}


	public String getParish() {
		return parish;
	}


	public void setParish(String parish) {
		this.parish = parish;
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
		return "Customer [custId=" + custId + ", company=" + company + ", contactPerson=" + contactPerson
				+ ", address1=" + address1 + ", address2=" + address2 + ", po=" + po + ", parish=" + parish + ", phone="
				+ phone + ", email=" + email + ", status=" + status + "]";
	}
	
	
	
	

}