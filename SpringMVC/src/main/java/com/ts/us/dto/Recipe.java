package com.ts.us.dto;

public class Recipe {
private int id;
private String name;
private String description;
private int isVeg;
private int cuisineId;

public Recipe() {
	// TODO Auto-generated constructor stub
}

public int getCuisineId() {
	return cuisineId;
}

public void setCuisineId(int cuisineId) {
	this.cuisineId = cuisineId;
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getIsVeg() {
	return isVeg;
}

public void setIsVeg(int isVeg) {
	this.isVeg = isVeg;
}

@Override
public String toString() {
	return "Recipe [id=" + id + ", name=" + name + ", description=" + description + ", is veg=" + isVeg + "cuisinenId:"+cuisineId+"]";
}


	 
}
