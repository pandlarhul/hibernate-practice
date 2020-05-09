package demo;

import javax.persistence.Id;


import javax.persistence.*;

@Entity

public class User {
	
	@Id
	private int id;
	
	private String name;
	
	@Embedded
	private Address address;
	
	
	public User() {
	
	}
	public User(int id, String name,  Address address)	{
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return id+" "+name+" "+address.getTown()+"  "+address.getCity();
	}
	
	

}
