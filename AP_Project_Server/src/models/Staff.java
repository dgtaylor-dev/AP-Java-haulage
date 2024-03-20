package models;

import java.io.Serializable;

public class Staff implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String address;
	private String phoneNum;
	private String email;
	private String position;
	private String status;
//	private int tripsDone;
	
	
	
	// constructors
	public Staff() 
	{
		
		Id = 0;
		this.firstName = "";
		this.lastName = "";
		this.dob = null;
		this.address = "";
		this.phoneNum = "(876)";
		this.email = "";
		this.position = "";
		this.status = "";
//		this.tripsDone = 0;
	}
	


	public Staff(String firstName, String lastName, Date dob, String address, 
			String phoneNum, String email,String position, String status) 
	{
		
//		Id = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.position = position;
		this.status = status;
//		this.tripsDone = tripsDone;
	}


	
//	Getters and Setters
	public int getStaffId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

//
//	public int getTripsDone() {
//		return tripsDone;
//	}

//
//	public void setTripsDone(int tripsDone) {
//		this.tripsDone = tripsDone;
//	}
	
	@Override
	public String toString() {
		return "Staff [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", address="
				+ address + ", phoneNum=" + phoneNum + ", email=" + email + ", position=" + position + ", status="
				+ status + "]";
	}

	

}