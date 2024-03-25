package models;



public class Contractor extends Staff{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private int numOfTrips = 0;
	
	public Contractor() {
		
	}

	public Contractor(String firstName, String lastName, Date dob, String address, String phone, String email,
			String position, String status, int tripsDone) {
		super(firstName, lastName, dob, address, phone, email, position, status);
		
		this.numOfTrips = tripsDone;
	}



}
