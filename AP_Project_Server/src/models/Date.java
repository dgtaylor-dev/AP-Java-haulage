package models;

public class Date {
	
	private String day;
	private String month;
	private String year;
	
	
	
	public Date() {
		
		this.day = "00";
		this.month = "00";
		this.year = "0000";
	}
	
	public Date(String day, String month, String year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Date: " + day + "-" + month + "-" + year ;
	}
	
	
	

}
