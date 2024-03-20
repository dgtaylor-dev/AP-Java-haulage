package models;

public class Trip {
	
	private int invoiceNum;
	private String company;
	private String sourceAddress;
	private double rate;
	private int contractor;
	private int billedBy;
	
	
//	constructors
public Trip() {
		
		this.invoiceNum = 0;
		this.company = "";
		this.sourceAddress ="";
		this.rate = 0;
		this.contractor = 0;
		this.billedBy = 0;
	}

	public Trip(int invoiceNum, String company, String sourceAddress, double rate, int contractor, int billedBy) {
		
		this.invoiceNum = invoiceNum;
		this.company = company;
		this.sourceAddress = sourceAddress;
		this.rate = rate;
		this.contractor = contractor;
		this.billedBy = billedBy;
	}
	
	
//Getters and Setters
	
	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getDriver() {
		return contractor;
	}

	public void setDriver(int contractor) {
		this.contractor = contractor;
	}

	public int  getBilledBy() {
		return billedBy;
	}

	public void setBilledBy(int billedBy) {
		this.billedBy = billedBy;
	}

	@Override
	public String toString() {
		return "Trip [invoiceNum=" + invoiceNum + ", company=" + company + ", sourceAddress=" + sourceAddress
				+ ", rate=" + rate + ", driver=" + contractor + ", billedBy=" + billedBy + "]";
	}
	
	
	
	
	
	
	
	

}
