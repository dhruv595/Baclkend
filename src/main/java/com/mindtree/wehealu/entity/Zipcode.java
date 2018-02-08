package com.mindtree.wehealu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zipcode")
public class Zipcode {

	
	@Id
	private int zipCode;
	@Column(nullable=false,length=20)
	private String area;
	@Column(nullable=false,length=20)
	private String city;
	@Column(nullable=false,length=15)
	private String state;
	
	public Zipcode() {
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Zipcode [zipCode=" + zipCode + ", area=" + area + ", city=" + city + ", state=" + state + "]";
	}

	
	
}
