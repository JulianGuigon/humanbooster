package com.topaidi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@Column(name="adressId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String country;
	private String city;
	private Integer postalCode;
	private String wording;
	private Integer streetNumber;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String country, String city, Integer postalCode, String wording, Integer streetNumber) {
		super();
		this.country = country;
		this.city = city;
		this.postalCode = postalCode;
		this.wording = wording;
		this.streetNumber = streetNumber;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", postalCode=" + postalCode + ", wording=" + wording
				+ ", streetNumber=" + streetNumber + "]";
	}
}
