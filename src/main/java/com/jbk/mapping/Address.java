package com.jbk.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	private long aid;
	private String city;
	private int pincode;
	private String state;
	private String country;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(long aid, String city, int pincode, String state, String country) {
		super();
		this.aid = aid;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", pincode=" + pincode + ", state=" + state + ", country="
				+ country + "]";
	}
	
	

}
