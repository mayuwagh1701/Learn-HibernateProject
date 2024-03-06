package com.jbk.mapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private long empId;
	private String empName;
	private double empSalery;
	
	private  Address address;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long empId, String empName, double empSalery, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalery = empSalery;
		this.address = address;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalery() {
		return empSalery;
	}

	public void setEmpSalery(double empSalery) {
		this.empSalery = empSalery;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalery=" + empSalery + ", address=" + address
				+ "]";
	}
	
	
	
	

}
