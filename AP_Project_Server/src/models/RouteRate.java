package models;

import java.io.Serializable;

public class RouteRate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int routeId;
	private String routeName;
	private String source;
	private String destination;
	private Double rate;
	
	
	public RouteRate(){
		
		this.routeId = 0;
		this.routeName = "";
		this.source = "";
		this.destination = "";
		this.rate = 0.00;
	}
	
	
	public RouteRate(String routeName, String source, String destination, Double rate) {
		this.routeName = routeName;
		this.source = source;
		this.destination = destination;
		this.rate = rate;
		
	}


	public int getRouteId() {
		return routeId;
	}


	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}


	public String getRouteName() {
		return routeName;
	}


	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Double getRate() {
		return rate;
	}


	public void setRate(Double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "RouteRate [routeId=" + routeId + ", routeName=" + routeName + ", source=" + source + ", destination="
				+ destination + ", rate=" + rate + "]";
	}


	
	

}
