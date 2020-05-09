package com.bridgelabz.controller;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Laptop {
	
	@Id 
	private int lid;
	
	private String name;

	@Temporal(TemporalType.DATE)
	private Date mfcDate;
	private String modelName;
	private boolean isOk;
	
	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public int getLid() {
		return lid;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	
	
	
	public void setName(String name) {
		this.name = name+" from setters";
	}


	public Date getMfcDate() {
		return mfcDate;
	}


	public void setMfcDate(Date mfcDate) {
		this.mfcDate = mfcDate;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	

}
