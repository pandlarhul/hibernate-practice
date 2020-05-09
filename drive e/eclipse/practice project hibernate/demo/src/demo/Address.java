package demo;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Embeddable
public class Address {
	private String town;
	private String city;
	private String pincode;
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	

}
