package models;



public class Pay {

	private String payID;
	private int staffID;
	private Date startDate;
	private Date endDate;
	private double salary;
	private int  preparedBy;
	
	
	public Pay() {
		
		this.payID = null;
		this.staffID = 0;
		this.startDate = new Date();
		this.endDate = new Date();
		this.salary = 0;
		this.preparedBy = 0;
	}
	
	public Pay(String payID, int staffID, Date startDate, Date endDate, double salary, int preparedBy) {
		
		this.payID = payID;
		this.staffID = staffID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.salary = salary;
		this.preparedBy = preparedBy;
	}

	
	
	public String getPayID() {
		return payID;
	}

	public void setPayID(String payID) {
		this.payID = payID;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(int preparedBy) {
		this.preparedBy = preparedBy;
	}
	
	

	@Override
	public String toString() {
		return "Pay [payID=" + payID + ", staffID=" + staffID + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", salary=" + salary + ", preparedBy=" + preparedBy + "]";
	}
	
	
	
	
	
}
