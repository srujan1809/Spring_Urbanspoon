package com.ts.us.dto;

import java.util.List;

public class Branch {
	private int id;
	private String location;
	private String city;
	private String state;
	private String country;
	private int postalCode;
	private String email;
	private long mobileNo;
	private List<Cuisine> cuisinesList;
	private List<String> imagesList;

	public Branch() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Cuisine> getCuisinesList() {
		return cuisinesList;
	}

	public void setCuisinesList(List<Cuisine> cuisinesList) {
		this.cuisinesList = cuisinesList;
	}

	public List<String> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", location=" + location + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", cuisinesList=" + cuisinesList + ", imagesList=" + imagesList + "]";
	}

}
